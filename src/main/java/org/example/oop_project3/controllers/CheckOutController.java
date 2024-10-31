package org.example.oop_project3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
public class CheckOutController {
    @FXML
    private Button ConfirmPaymentButton;
    private Stage stage;
    private Scene scene;

    public void initialize() {
        ConfirmPaymentButton.setOnAction(this::showPaymentSuccessPopup);
    }

    private void showPaymentSuccessPopup(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("The payment was made successfully!");

        alert.setOnHidden(dialogEvent -> navigateToHome(event));
        alert.showAndWait();
    }
@FXML
    private void navigateToHome(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/oop_project3/home.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
