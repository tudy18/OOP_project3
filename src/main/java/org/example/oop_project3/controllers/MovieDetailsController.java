package org.example.oop_project3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.oop_project3.models.MovieDetails;

import java.io.IOException;
public class MovieDetailsController {
    @FXML
    private Button backBtn;
    @FXML
    private Label titleLabel, genreLabel, releaseDateLabel, descriptionLabel;
    @FXML
    private ImageView posterImageView;
    @FXML
    private VBox scheduleContainer;

    private MovieDetails selectedMovie;

    public MovieDetailsController() {
    }

    @FXML
    private void initialize() {
        if (selectedMovie != null) {
            titleLabel.setText(selectedMovie.getTitle());
            genreLabel.setText(selectedMovie.getGenre());
            releaseDateLabel.setText(selectedMovie.getReleaseDate());
            descriptionLabel.setText(selectedMovie.getDescription());
            loadScheduleButtons();
        }

        backBtn.setOnAction(e -> loadHomeView());
    }

    public void setSelectedMovie(MovieDetails selectedMovie) {
        this.selectedMovie = selectedMovie;
        if (titleLabel != null) {
            titleLabel.setText(selectedMovie.getTitle());
            genreLabel.setText(selectedMovie.getGenre());
            releaseDateLabel.setText(selectedMovie.getReleaseDate());
            descriptionLabel.setText(selectedMovie.getDescription());
            loadScheduleButtons();
        }
    }

    private void loadScheduleButtons() {
        scheduleContainer.getChildren().clear();
        selectedMovie.getTimesByDate().forEach((date, times) -> {
            Label dateLabel = new Label("Date: " + date);
            dateLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");
            scheduleContainer.getChildren().add(dateLabel);

            for (int i = 0; i < times.size(); i++) {
                String time = times.get(i);
                String hall = selectedMovie.getHallsForDate(date).get(i);
                Button scheduleButton = new Button(time + " - Hall " + hall + " (" + selectedMovie.getFormat() + ")");
                scheduleContainer.getChildren().add(scheduleButton);
                scheduleButton.setOnAction(e -> handleScheduleButtonClick(date, time, hall));
            }
        });
    }

    private void handleScheduleButtonClick(String date, String time, String hall) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/oop_project3/reservationConfirmation.fxml"));
            Parent reservationRoot = loader.load();

            ReservationController reservationController = loader.getController();
            reservationController.setReservationDetails(selectedMovie, date, time, hall);

            Stage stage = (Stage) scheduleContainer.getScene().getWindow();
            Scene reservationScene = new Scene(reservationRoot);
            stage.setScene(reservationScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadHomeView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/oop_project3/home.fxml"));
            Parent homeRoot = loader.load();
            Stage stage = (Stage) backBtn.getScene().getWindow();
            stage.setScene(new Scene(homeRoot));
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
