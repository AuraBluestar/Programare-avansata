package controller;

import model.Genre;
import model.Singleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenreDAO {

    private static final String selectQuery =
            "select g.ID, g.NAME " +
                    "from GENRES g ";
    private static String selectWhereId;
    private static String selectWhereName;

    static {
        selectWhereId = "select g.ID, g.NAME " +
                "from GENRES g where g.ID=";
    }

    static {
        selectWhereName = "select g.ID, g.NAME " +
                "from GENRES g where g.NAME like '";
    }

    public GenreDAO() {
    }

    public void getGenres(){
        try {
            Statement statement = Singleton.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                System.out.println(new Genre(id, name));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public Genre findById(String ID) {
        try {
            Statement statement = Singleton.getConnection().createStatement();
            selectWhereId = selectWhereId + ID;
            ResultSet resultSet = statement.executeQuery(selectWhereId);
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String title = resultSet.getString(2);
                return new Genre(id, title);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public Genre findByName(String name){
        try {
            Statement statement = Singleton.getConnection().createStatement();
            selectWhereName = new StringBuilder().append(selectWhereName).append(name).append("'").toString();
            ResultSet resultSet = statement.executeQuery(selectWhereName);
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String title = resultSet.getString(2);
                return new Genre(id, title);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
