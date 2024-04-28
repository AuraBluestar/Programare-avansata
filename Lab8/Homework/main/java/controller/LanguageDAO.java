package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Genre;
import model.Language;
import model.Singleton;

public class LanguageDAO {
    private static final String selectQuery =
            "select l.ID, l.NAME " +
                    "from LANGUAGES l ";
    private static String selectWhereId;
    private static String selectWhereName;

    static {
        selectWhereId = "select l.ID, l.NAME " +
                "from LANGUAGES l where l.ID=";
    }

    static {
        selectWhereName = "select l.ID, l.NAME " +
                "from LANGUAGES l where l.NAME like '";
    }

    public LanguageDAO() {
    }

    public void getLanguages(){
        try {
            Statement statement = Singleton.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                System.out.println(new Language(id, name));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public Language findById(String ID) {
        try {
            Statement statement = Singleton.getConnection().createStatement();
            selectWhereId = selectWhereId + ID;
            ResultSet resultSet = statement.executeQuery(selectWhereId);
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                return new Language(id, name);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public Language findByName(String name){
        try {
            Statement statement = Singleton.getConnection().createStatement();
            selectWhereName = new StringBuilder().append(selectWhereName).append(name).append("'").toString();
            ResultSet resultSet = statement.executeQuery(selectWhereName);
            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String title = resultSet.getString(2);
                return new Language(id, title);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
