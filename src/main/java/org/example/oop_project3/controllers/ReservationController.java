package org.example.oop_project3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.oop_project3.models.ReservationConfirmation;

import java.io.IOException;

public class ReservationController
{
        ReservationConfirmation reservationConfirmation;
        CheckOutController checkOutController;
        @FXML
        private Button confirmReservationButton;

        public void showReservationConfirmation(Stage primaryStage) throws IOException
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/controllers/ReservationConfirmation/reservationConfirmation.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            confirmReservationButton.setOnAction(e -> {
                try {
                    checkOutController.proceedToCheckOut(primaryStage);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }



}
