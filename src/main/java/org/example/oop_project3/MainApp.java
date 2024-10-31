package org.example.oop_project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.oop_project3.controllers.HomeController;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
