package org.example.oop_project3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/movie";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    public Connection connectToDatabase() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to database");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
