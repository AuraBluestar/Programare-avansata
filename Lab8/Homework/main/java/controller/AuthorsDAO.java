package controller;

import model.Singleton;
import model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDAO {
    private static final String selectQuery =
            "select a.ID, a.NAME" + "from Authors a ";
    private static String selectWhereId;
    private static String selectWhereName;

    static {
        selectWhereId =  "select a.ID, a.NAME" + "from Authors a where a.ID=";
    }

    static {
        selectWhereName =  "select a.ID, a.NAME" + "from Authors a where a.NAME like '";
    }

    public AuthorsDAO() {
    }

    public void getAuthors() {
        try {
            Statement statement = Singleton.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                System.out.println(new Author(id, name));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public Author findById(String ID) {
        try {
            Statement statement = Singleton.getConnection().createStatement();
            selectWhereId = selectWhereId + ID;
            ResultSet resultSet = statement.executeQuery(selectWhereId);
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                return new Author(id, name);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public List<Author> findByName(String name) {
        List<Author> authorList = new ArrayList<>();
        try {
            Statement statement = Singleton.getConnection().createStatement();
            selectWhereName = new StringBuilder().append(selectWhereName).append(name).append("'").toString();
            ResultSet resultSet = statement.executeQuery(selectWhereName);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                authorList.add(new Author(id, name));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return authorList;
    }

}
