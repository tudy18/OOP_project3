package org.example.oop_project3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.oop_project3.models.MovieDetails;
import org.example.oop_project3.utils.dbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @FXML
    private void initialize() {
        if (selectedMovie != null) {
            titleLabel.setText(selectedMovie.getTitle());
            genreLabel.setText(selectedMovie.getGenre());
            releaseDateLabel.setText(selectedMovie.getReleaseDate());
            descriptionLabel.setText(selectedMovie.getDescription());
            loadMovieSchedules();
            loadPosterImage();}

        backBtn.setOnAction(e -> loadHomeView());
    }

    public void setSelectedMovie(MovieDetails selectedMovie) {
        this.selectedMovie = selectedMovie;
        if (titleLabel != null) {
            titleLabel.setText(selectedMovie.getTitle());
            genreLabel.setText(selectedMovie.getGenre());
            releaseDateLabel.setText(selectedMovie.getReleaseDate());
            descriptionLabel.setText(selectedMovie.getDescription());
            loadMovieSchedules();
            loadPosterImage();
        }
    }

    private void loadPosterImage() {
        try {
            if (selectedMovie.getImagePath() != null) {
                Image posterImage = new Image("file:" + selectedMovie.getImagePath());
                posterImageView.setImage(posterImage);
            }
        } catch (Exception e) {
            System.err.println("Error loading poster image: " + e.getMessage());
        }
    }


    private void loadMovieSchedules() {
        if (selectedMovie == null) return;

        String query = "SELECT schedule_date, show_time, screen_number FROM schedules s "
                + "JOIN movies m ON s.movie_id = m.movie_id "
                + "WHERE m.title = ?";
        try (Connection connection = new dbConnection().connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, selectedMovie.getTitle());
            ResultSet resultSet = statement.executeQuery();

            Map<String, List<String>> timesByDate = new HashMap<>();
            Map<String, List<String>> hallsByDate = new HashMap<>();

            while (resultSet.next()) {
                String date = resultSet.getString("schedule_date");
                String time = resultSet.getString("show_time");
                String hall = resultSet.getString("screen_number");

                timesByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(time);
                hallsByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(hall);
            }

            // Add schedules to the selected movie
            for (String date : timesByDate.keySet()) {
                selectedMovie.addSchedule(date, timesByDate.get(date), hallsByDate.get(date));
            }

            loadScheduleButtons(); // Load buttons after schedules are fetched

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadScheduleButtons() {
        scheduleContainer.getChildren().clear();
        if (selectedMovie != null) {
            Map<String, List<String>> timesByDate = selectedMovie.getTimesByDate();
            Map<String, List<String>> hallsByDate = selectedMovie.getHallsByDate();

            timesByDate.forEach((date, times) -> {
                Label dateLabel = new Label("Date: " + date);
                dateLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");
                scheduleContainer.getChildren().add(dateLabel);

                List<String> halls = hallsByDate.get(date);
                for (int i = 0; i < times.size(); i++) {
                    String time = times.get(i);
                    String hall = halls.get(i);  // Get the corresponding hall for the time
                    Button scheduleButton = new Button(time + " - Hall " + hall + " (" + selectedMovie.getFormat() + ")");
                    scheduleContainer.getChildren().add(scheduleButton);
                    scheduleButton.setOnAction(e -> handleScheduleButtonClick(date, time, hall, selectedMovie.getFormat()));
                }
            });
        }
    }

    private void handleScheduleButtonClick(String date, String time, String hall, String format) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/oop_project3/selectTickets.fxml"));
            Parent reservationRoot = loader.load();

            SelectTicketsController selectTicketsController = loader.getController();
            selectTicketsController.setMovieAndScheduleDetails(selectedMovie, date, time, hall, format);

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
