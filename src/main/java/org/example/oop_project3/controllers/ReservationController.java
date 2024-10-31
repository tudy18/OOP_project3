package org.example.oop_project3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.oop_project3.models.MovieDetails;

import java.io.IOException;
import java.util.Objects;

public class ReservationController {

    private MovieDetails movieDetails;
    private String selectedDate;
    private String selectedTime;
    private String selectedHall;
    private Stage stage;

    @FXML
    private Label titleLabel, hallLabel, timeLabel, dateLabel, formatLabel;
    @FXML
    private Button confirmReservationButton;

    public void setReservationDetails(MovieDetails movieDetails, String date, String time, String hall) {
        this.movieDetails = movieDetails;
        this.selectedDate = date;
        this.selectedTime = time;
        this.selectedHall = hall;
    }

    @FXML
    private void initialize() {
        if (movieDetails != null) {
            titleLabel.setText("Title: " + movieDetails.getTitle());
            hallLabel.setText("Hall: " + selectedHall);
            timeLabel.setText("Time: " + selectedTime);
            dateLabel.setText("Date: " + selectedDate);
            formatLabel.setText("Format: " + movieDetails.getFormat());
        }

    }
    @FXML
    public void checkOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/oop_project3/checkOut.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene (scene);
    }

    @FXML
    private void goToSelectSeats(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/oop_project3/seatSelection.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
