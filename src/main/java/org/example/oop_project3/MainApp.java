package org.example.oop_project3;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainApp extends Application {


    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application

    }

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/oop_project3/hello-view.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("JavaFX Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
