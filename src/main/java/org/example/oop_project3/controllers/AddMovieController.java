package org.example.oop_project3.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.oop_project3.dao.MovieDao;
import org.example.oop_project3.models.MovieDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddMovieController {
    @FXML
    private TextField titleField, genreField, releaseDateField, imagePathField, durationField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private ComboBox<String> formatComboBox;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField dateField, timeField, hallField;
    @FXML
    private TextArea scheduleDisplay;
    @FXML
    private Button addScheduleButton;
    private Map<String, List<String>> timesByDate = new HashMap<>();
    private Map<String, List<String>> hallsByDate = new HashMap<>();

    private Stage stage;
    private HomeController homeController;
    public AddMovieController() {
    }
    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

    @FXML
    public void initialize() {
        formatComboBox.getItems().addAll("2D", "3D");
    }


    @FXML
    private void handleAddSchedule() {
        String date = dateField.getText();
        String time = timeField.getText();
        String hall = hallField.getText();

        if (!date.isEmpty() && !time.isEmpty() && !hall.isEmpty()) {
            timesByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(time);
            hallsByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(hall);

            StringBuilder scheduleText = new StringBuilder();
            for (String d : timesByDate.keySet()) {
                scheduleText.append("Date: ").append(d).append("\n");
                List<String> times = timesByDate.get(d);
                List<String> halls = hallsByDate.get(d);
                for (int i = 0; i < times.size(); i++) {
                    scheduleText.append("   ").append(times.get(i)).append(" in ").append(halls.get(i)).append("\n");
                }
            }
            scheduleDisplay.setText(scheduleText.toString());

            dateField.clear();
            timeField.clear();
            hallField.clear();
        } else {
            statusLabel.setText("Please fill all schedule fields.");
        }
    }
    @FXML
    private void handleAddButton() {
        try {
            String title = titleField.getText();
            String genre = genreField.getText();
            String releaseDate = releaseDateField.getText();
            String imagePath = imagePathField.getText();
            String description = descriptionArea.getText();
            int duration = Integer.parseInt(durationField.getText());
            String format = formatComboBox.getValue();

            MovieDetails newMovie = new MovieDetails(title, genre, releaseDate, imagePath, description, duration, format);
            for (String date : timesByDate.keySet()) {
                newMovie.addSchedule(date, timesByDate.get(date), hallsByDate.get(date));
            }

            MovieDao.saveMovie(newMovie);
            homeController.refreshMovies();
            statusLabel.setText("Movie added successfully!");
            statusLabel.setStyle("-fx-text-fill: green;");
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setText("Failed to add movie.");
        }
    }

}
