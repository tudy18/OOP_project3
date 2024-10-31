package org.example.oop_project3.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckOutController {
    public void proceedToCheckOut(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/oop_project3/checkOut.fxml"));
        Parent checkOutRoot = loader.load();
        Scene checkOutScene = new Scene(checkOutRoot);
        primaryStage.setScene(checkOutScene);
    }
}
