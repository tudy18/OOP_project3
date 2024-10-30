
package org.example.oop_project3.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.oop_project3.models.MovieDetails;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HomeController {
    @FXML
    private ListView<MovieDetails> movieListView;
    @FXML
    private Button addMovieButton;

    private ObservableList<MovieDetails> movieList;

    public HomeController() {
        movieList = FXCollections.observableArrayList();
    }

    public void loadHomeView(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/oop_project3/home.fxml"));
        loader.setController(this);
        Parent root = loader.load();

        loadSampleMovies();
        movieListView.setItems(movieList);
        movieListView.setCellFactory(param -> new MovieCell());

        setupListViewActions(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadSampleMovies() {
        List<MovieDetails> movies = Arrays.asList(
                new MovieDetails("Inception", "Sci-Fi", "2010", "/images/inception.jpg", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.", 120, "2D"),
                new MovieDetails("The Matrix", "Action", "1999", "/images/the_matrix.jpg", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", 150, "2D"),
                new MovieDetails("Interstellar", "Sci-Fi", "2014", "/images/interstellar.jpg", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", 169, "3D"),
                new MovieDetails("The Godfather", "Crime", "1972", "/images/the_godfather.jpg", "An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son.", 175, "2D"),
                new MovieDetails("Pulp Fiction", "Crime", "1994", "/images/pulp_fiction.jpg", "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", 154, "2D")
        );

        movieList.addAll(movies);
    }

    private void setupListViewActions(Stage primaryStage) {
        movieListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                MovieDetails selectedMovie = movieListView.getSelectionModel().getSelectedItem();
                if (selectedMovie != null) {
                    loadMovieDetailsView(primaryStage, selectedMovie);
                }
            }
        });
    }

    private void loadMovieDetailsView(Stage primaryStage, MovieDetails selectedMovie) {
        MovieDetailsController movieDetailsController = new MovieDetailsController(selectedMovie, primaryStage);
        movieDetailsController.loadFXML();
    }

    public void addMovie(MovieDetails movie) {
        movieList.add(movie);
    }
}
