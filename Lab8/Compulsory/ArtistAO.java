package lab8.lab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistAO {
    public void create(String name) throws SQLException {
 Connection con = Database.getConnection();
 try (PreparedStatement pstmt = con.prepareStatement(
 "insert into authors (name) values (?)")) {
 pstmt.setString(1, name);
 pstmt.executeUpdate();
 }
 }
 public Integer findByName(String name) throws SQLException {
 Connection con = Database.getConnection();
 try (Statement stmt = con.createStatement();
 ResultSet rs = stmt.executeQuery(
 "select id from authors where name='" + name + "'")) {
 return rs.next() ? rs.getInt(1) : null;
 }
 }
 public String findById(int id) throws SQLException {
 //TODO
        return null;
 //TODO
 }
}
