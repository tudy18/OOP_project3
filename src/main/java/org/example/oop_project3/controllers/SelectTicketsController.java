package org.example.oop_project3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.oop_project3.models.MovieDetails;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class SelectTicketsController {
    @FXML
    private Label movieTitleLabel, movieFormatLabel, movieGenreLabel, movieDateTimeLabel, movieHallLabel, adultCount, childCount, studentCount, totalPrice;

    private Stage stage;
    private Scene scene;

    private final double adultPrice = 50.0;
    private final double childPrice = 30.0;
    private final double studentPrice = 25.0;

    private int adultTickets = 0;
    private int childTickets = 0;
    private int studentTickets = 0;

    private String date;
    private String time;
    private String hall;
    private String format;
    private MovieDetails selectedMovie;

    public void setMovieAndScheduleDetails(MovieDetails selectedMovie, String date, String time, String hall, String format) {
        this.selectedMovie = selectedMovie;
        this.date = date;
        this.time = time;
        this.hall = hall;
        this.format=format;
        movieTitleLabel.setText(selectedMovie.getTitle());
        movieGenreLabel.setText(selectedMovie.getGenre());
        movieDateTimeLabel.setText(date+" at " +time);
        movieFormatLabel.setText(format);
        movieHallLabel.setText("Hall " + hall);
    }

    @FXML
    public void incrementAdult() {
        adultTickets++;
        adultCount.setText(String.valueOf(adultTickets));
        updateTotalPrice();
    }

    @FXML
    public void incrementChild() {
        childTickets++;
        childCount.setText(String.valueOf(childTickets));
        updateTotalPrice();
    }

    @FXML
    public void incrementStudent() {
        studentTickets++;
        studentCount.setText(String.valueOf(studentTickets));
        updateTotalPrice();
    }

    @FXML
    public void decrementAdult() {
        if (adultTickets > 0) {
            adultTickets--;
            adultCount.setText(String.valueOf(adultTickets));
            updateTotalPrice();
        }
    }

    @FXML
    public void decrementChild() {
        if (childTickets > 0) {
            childTickets--;
            childCount.setText(String.valueOf(childTickets));
            updateTotalPrice();
        }
    }

    @FXML
    public void decrementStudent() {
        if (studentTickets > 0) {
            studentTickets--;
            studentCount.setText(String.valueOf(studentTickets));
            updateTotalPrice();
        }
    }

    private void updateTotalPrice() {
        double total = (adultTickets * adultPrice) + (childTickets * childPrice) + (studentTickets * studentPrice);
        totalPrice.setText(String.format("%.2f", total));
    }

    @FXML
    private void nextStep(javafx.event.ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/oop_project3/seatSelection.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
    }
}
