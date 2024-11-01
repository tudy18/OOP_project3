package org.example.oop_project3;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        stage.setOnCloseRequest(event->{
            event.consume();
            Logout(stage);
        });

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/org/example/oop_project3/register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MovieStar");
        stage.setScene(scene);
        stage.show();
    }
    public void Logout(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Do you want to log out?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have logged out");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}