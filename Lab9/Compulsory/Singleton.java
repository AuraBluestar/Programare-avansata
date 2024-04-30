package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

    private static Connection connection = null;
    private static String url;
    private static String user;
    private static String password;

    public Singleton() {
    }

    public static Connection getConnection() {
        if(connection != null) {
            return connection;
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
            return null;
        }
        return connection;
    }

    public static void setConnection(Connection connection) {
        Singleton.connection = connection;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Singleton.url = url;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Singleton.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Singleton.password = password;
    }
}
