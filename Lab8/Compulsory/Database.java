package lab8.lab8;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private static final String URL
            = "jdbc:postgresql://localhost:5432/books";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;

    static void rollback() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Database() {
    }

    public static Connection getConnection() {
        //TODO
        return null;
        //TODO

    }

    private static void createConnection() {
        try {
            //Connection = TODO
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
//TODO 
    }
}
