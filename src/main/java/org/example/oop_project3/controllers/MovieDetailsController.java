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
    private Label titleLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label releaseDateLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private ImageView posterImageView;
    @FXML
    private VBox scheduleContainer;

    private final MovieDetails selectedMovie;
    private final Stage stage;
HomeController homeController;
    public MovieDetailsController(MovieDetails selectedMovie, Stage stage) {
        this.selectedMovie = selectedMovie;
        this.stage = stage;
    }

    public void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/oop_project3/movieDetails.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            initializeView();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeView() {
        titleLabel.setText(selectedMovie.getTitle());
        genreLabel.setText(selectedMovie.getGenre());
        releaseDateLabel.setText(selectedMovie.getReleaseDate());
        descriptionLabel.setText(selectedMovie.getDescription());
        loadScheduleButtons();
        homeController=new HomeController();
        backBtn.setOnAction(e-> {
            try {
                homeController.loadHomeView(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void loadScheduleButtons() {
        selectedMovie.getTimesByDate().forEach((date, times) -> {
            for (int i = 0; i < times.size(); i++) {
                String time = times.get(i);
                String hall = selectedMovie.getHallsForDate(date).get(i);
                Button scheduleButton = new Button(time + " HALL " + hall + " " + selectedMovie.getFormat());
                scheduleContainer.getChildren().add(scheduleButton);
            }
        });

    }
}
