package org.example.oop_project3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection  extends Application{

        private final String JDBC_URL = "jdbc:mysql://localhost:3306/movie";
        private final String USERNAME = "root";
        private final String PASSWORD = "";

        public static void main(String[] args) {
            launch(args); // Launch the JavaFX application
        }

        @Override
        public void start(Stage primaryStage) {

            boolean isConnected = connectToDatabase();

            Label label = new Label(isConnected ? "Connected to Database" : "Failed to Connect");
            StackPane root = new StackPane(label);
            Scene scene = new Scene(root, 300, 200);

            primaryStage.setTitle("JavaFX MySQL Connection");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private boolean connectToDatabase() {
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                System.out.println("Connection successful!");
                connection.close();
                return true;
            } catch (SQLException e) {
                System.out.println("Error connecting to the database.");
                e.printStackTrace();
                return false;
            }
        }
    }
