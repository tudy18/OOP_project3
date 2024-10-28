package org.example.oop_project3;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.oop_project3.controllers.HomeController;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new HomeController(primaryStage);
    }
}
