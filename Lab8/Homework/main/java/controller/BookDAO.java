package controller;

import exceptions.FileException;
import model.Book;
import model.Singleton;
import tools.ImportFromCSV;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static final String selectQuery =
            "select b.ID, b.TITLE, b.RELEASE_DATE, b.NR_PAGES, b.SCORE " +
                    "from BOOKS b ";
    private static String selectWhereId;
    private static String selectWhereName;
    private static String insertQuery =
            "insert into BOOKS values(autoincrementBooks.nextVal, ?, ?, ?, ?)";

    static {
        selectWhereId = "select b.ID, b.TITLE, m.RELEASE_DATE, b.NR_PAGES, b.SCORE " +
                "from BOOKS b where b.ID=";
    }

    static {
        selectWhereName = "select b.ID, b.TITLE, b.RELEASE_DATE, b.NR_PAGES, b.SCORE " +
                "from BOOKS b where b.TITLE like '";
    }


    public BookDAO() {
    }

    public void getBooks() {
        try {
            Statement statement = Singleton.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String title = resultSet.getString(2);
                String releaseDate = resultSet.getString(3);
                Integer nr_pages = resultSet.getInt(4);
                Double score = resultSet.getDouble(5);
                System.out.println(new Book(id, title, releaseDate, nr_pages, score));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public Book findById(String ID) {
        try {
            Statement statement = Singleton.getConnection().createStatement();
            selectWhereId = selectWhereId + ID;
            ResultSet resultSet = statement.executeQuery(selectWhereId);
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String title = resultSet.getString(2);
                String releaseDate = resultSet.getString(3);
                Integer nr_pages = resultSet.getInt(4);
                Double score = resultSet.getDouble(5);
                return new Book(id, title, releaseDate, nr_pages, score);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public List<Book> findByName(String name) {
        List<Book> bookList = new ArrayList<>();
        try {
            Statement statement = Singleton.getConnection().createStatement();
            selectWhereName = new StringBuilder().append(selectWhereName).append(name).append("'").toString();
            ResultSet resultSet = statement.executeQuery(selectWhereName);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String title = resultSet.getString(2);
                String releaseDate = resultSet.getString(3);
                Integer nr_pages = resultSet.getInt(4);
                Double score = resultSet.getDouble(5);
                bookList.add(new Book(id, title, releaseDate, nr_pages, score));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return bookList;
    }

    public void importBooks(ImportFromCSV importFromCSV) {
        try {
            PreparedStatement statement = Singleton.getConnection().prepareStatement(insertQuery);
            List<String[]> data = importFromCSV.getAttributes(2, 4, 6, 14);
            for (int index = 1; index < data.size(); index++) {
                String title = data.get(index)[0];
                Date releaseDate = null;
                Integer duration = Integer.valueOf(data.get(index)[2]);
                if (!(data.get(index)[1].indexOf('-') == -1 ||
                        data.get(index)[1].lastIndexOf('-') ==
                                data.get(index)[1].indexOf('-'))) {
                    releaseDate = Date.valueOf(data.get(index)[1]);
                }
                Double score = Double.valueOf(data.get(index)[3]);
                statement.setString(1, title);
                statement.setDate(2, releaseDate);
                statement.setInt(3, duration);
                statement.setDouble(4, score);
                statement.execute();
            }
        } catch (SQLException | FileException throwable) {
            throwable.printStackTrace();
        }
    }
}
