package org.example.oop_project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.oop_project3.controllers.HomeController;
public class MainApp extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            HomeController homeController = new HomeController();
            homeController.loadHomeView(primaryStage);
        }

    public static void main(String[] args) {
        launch(args);
    }
}
