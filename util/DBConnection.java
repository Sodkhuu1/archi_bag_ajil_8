package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Өгөгдлийн сантай холбогдох функц
    public static Connection getConnection() throws SQLException {
        // Хост, хэрэглэгчийн нэр, нууц үгээ тохируулна
        String url = "jdbc:mysql://localhost:3306/online_hospital";
        String username = "root";
        String password = "password";

        return DriverManager.getConnection(url, username, password);
    }
}
