package org.example.oop_project3.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.oop_project3.models.Movie;

public class HomeController {

    @FXML
    private ListView<Movie> movieListView;

    public HomeController(Stage stage) {
        initialize(stage);
    }

    private void initialize(Stage stage) {
        BorderPane root = new BorderPane();
        HBox searchBar = new HBox();
        searchBar.setStyle("-fx-background-color: #D32F2F; -fx-padding: 15;");

        javafx.scene.control.TextField searchField = new javafx.scene.control.TextField();
        searchField.setPromptText("Search for movies...");
        searchField.setStyle("-fx-max-width: 300; -fx-padding: 10; -fx-background-radius: 10px; -fx-background-color: #EEEEEE; -fx-text-fill: gray;");

        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #D32F2F; -fx-text-fill: white;");

        searchBar.getChildren().addAll(searchField, searchButton);
        root.setTop(searchBar);

        movieListView = new ListView<>();
        movieListView.setCellFactory(new Callback<ListView<Movie>, ListCell<Movie>>() {
            @Override
            public ListCell<Movie> call(ListView<Movie> listView) {
                return new MovieListCell();
            }
        });

        Movie movie1 = new Movie("Inception", "Sci-Fi", "2010", "inception.jpg", "no description yet");
        Movie movie2 = new Movie("The Matrix", "Action", "1999", "the matrix", "no description yet");
        movieListView.getItems().addAll(movie1, movie2);

        VBox vbox = new VBox(movieListView);
        vbox.setStyle("-fx-padding: 20;");
        root.setCenter(vbox);

        Scene scene = new Scene(root, 665, 481);
        stage.setScene(scene);
        stage.show();
    }

    private static class MovieListCell extends ListCell<Movie> {
        private final VBox vbox = new VBox();
        private final ImageView imageView = new ImageView();
        private final Label titleLabel = new Label();
        private final Label genreLabel = new Label();
        private final Label releaseDateLabel = new Label();

        public MovieListCell() {
            imageView.setFitWidth(100);
            imageView.setFitHeight(150);
            titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
            genreLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666666;");
            releaseDateLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666666;");

            vbox.setSpacing(5);
            vbox.getChildren().addAll(imageView, titleLabel, genreLabel, releaseDateLabel);
        }

        @Override
        protected void updateItem(Movie movie, boolean empty) {
            super.updateItem(movie, empty);

            if (empty || movie == null) {
                setGraphic(null);
            } else {
               // imageView.setImage(new Image(movie.getImagePath()));
                titleLabel.setText(movie.getTitle());
                genreLabel.setText("Genre: " + movie.getGenre());
                releaseDateLabel.setText("Release Date: " + movie.getReleaseDate());

                setGraphic(vbox);
            }
        }
    }
}
