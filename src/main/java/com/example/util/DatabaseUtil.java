package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://db4free.net:3306/your_db_name?useSSL=false"; // Thay sau
    private static final String USER = "your_db_username"; // Thay sau
    private static final String PASSWORD = "your_db_password"; // Thay sau

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found.");
        }
    }
}
