package org.example.oop_project3.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.oop_project3.models.MovieDetails;

public class AddMovieController {
    @FXML
    private TextField titleField, genreField, releaseDateField, imagePathField, durationField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private ComboBox<String> formatComboBox;
    @FXML
    private Button addButton;
    @FXML
    private Label statusLabel;

    private Stage stage;
    private HomeController homeController;
    public AddMovieController() {
    }
    public AddMovieController(HomeController homeController, Stage stage) {
        this.homeController = homeController;
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        formatComboBox.getItems().addAll("2D", "3D");
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

            if (title.isEmpty() || genre.isEmpty() || releaseDate.isEmpty() || imagePath.isEmpty() || description.isEmpty() || format == null) {
                statusLabel.setText("Please fill in all fields.");
                statusLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            MovieDetails newMovie = new MovieDetails(title, genre, releaseDate, imagePath, description, duration, format);


            statusLabel.setText("Movie added successfully!");
            statusLabel.setStyle("-fx-text-fill: green;");

            stage.close();

        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid duration. Please enter a number.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
