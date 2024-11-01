package org.example.oop_project3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeatSelectionController {

    @FXML
    private GridPane seatGrid;

    @FXML
    private Button nextStepButton;

    private List<Button> selectedSeats = new ArrayList<>();
    private int seatCount;
    private Stage stage;

    private String movieTitle;
    private String hall;
    private String date;
    private String time;
    private String format;


    public void initializeWithSeatCount(int seatCount, String date, String time, String hall, String format) {
        this.seatCount = seatCount;
        this.date = date;
        this.time = time;
        this.hall = hall;
        this.format = format;
        nextStepButton.setDisable(true);  // Disable until required seats are selected
        loadSeats();
    }


    private void loadSeats() {
        for (Node node : seatGrid.getChildren()) {
            if (node instanceof Button) {
                Button seatButton = (Button) node;
                seatButton.setOnAction(event -> handleSeatSelection(seatButton));
            }
        }
    }

    private void handleSeatSelection(Button seatButton) {
        if (selectedSeats.contains(seatButton)) {
            seatButton.setStyle("-fx-background-color: grey; -fx-background-radius: 8;");
            selectedSeats.remove(seatButton);
        } else if (selectedSeats.size() < seatCount) {
            seatButton.setStyle("-fx-background-color: #1976D2; -fx-background-radius: 8; -fx-text-fill: white;");
            selectedSeats.add(seatButton);
        }

        nextStepButton.setDisable(selectedSeats.size() != seatCount);
    }

    @FXML
    private void handleNextStep(ActionEvent event) throws IOException {
        if (selectedSeats.size() == seatCount) {
            List<String> seatIds = new ArrayList<>();
            for (Button seat : selectedSeats) {
                seatIds.add(seat.getId());
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/oop_project3/reservationConfirmation.fxml"));
            Parent root = loader.load();

            // Get the controller and pass reservation details
            ReservationController reservationController = loader.getController();
            reservationController.setReservationDetails(movieTitle, hall, seatIds, date, time);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selection Incomplete");
            alert.setHeaderText("Please select the required number of seats.");
            alert.showAndWait();
        }
    }
}
