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
import java.util.List;
import java.util.Objects;

public class ReservationController {

    private MovieDetails movieDetails;
    private String selectedDate;
    private String selectedTime;
    private String selectedHall;
    private Stage stage;

    @FXML
    private Label titleLabel, hallLabel, timeLabel, dateLabel, seatLabel, nameLabel, contactLabel;
    @FXML
    private Button confirmReservationButton;

    @FXML
    public void setReservationDetails(String title, String hall, List<String> seats, String date, String time) {
        titleLabel.setText("Movie Title: " + title);
        hallLabel.setText("Hall: " + hall);
        seatLabel.setText("Seat Number(s): " + String.join(", ", seats));
        dateLabel.setText("Date: " + date);
        timeLabel.setText("Time: " + time);
    }

    @FXML
    public void checkOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/oop_project3/checkOut.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene (scene);
    }

    @FXML
    private void goToHome(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/oop_project3/home.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
