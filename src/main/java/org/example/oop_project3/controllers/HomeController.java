
package org.example.oop_project3.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
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

    @FXML
    private void initialize() {
        List<MovieDetails> movies = Arrays.asList(
                new MovieDetails("Inception", "Sci-Fi", "2010", "/images/inception.jpg", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.", 120, "2D"),
                new MovieDetails("The Matrix", "Action", "1999", "/images/the_matrix.jpg", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", 150, "2D"),
                new MovieDetails("Interstellar", "Sci-Fi", "2014", "/images/interstellar.jpg", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", 169, "3D"),
                new MovieDetails("The Godfather", "Crime", "1972", "/images/the_godfather.jpg", "An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son.", 175, "2D"),
                new MovieDetails("Pulp Fiction", "Crime", "1994", "/images/pulp_fiction.jpg", "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", 154, "2D")
        );

        movies.get(0).addSchedule("2024-11-01", List.of("10:00 AM", "1:00 PM", "6:00 PM"), List.of("1", "2", "3"));
        movies.get(0).addSchedule("2024-11-02", List.of("11:00 AM", "2:00 PM", "8:00 PM"), List.of("1", "3", "2"));

        movies.get(1).addSchedule("2024-11-01", List.of("12:00 PM", "3:00 PM", "8:00 PM"), List.of("1", "2", "4"));
        movies.get(1).addSchedule("2024-11-03", List.of("1:00 PM", "4:00 PM", "9:00 PM"), List.of("3", "2", "1"));

        movies.get(2).addSchedule("2024-11-01", List.of("2:00 PM", "5:00 PM", "9:00 PM"), List.of("3", "1", "2"));
        movies.get(2).addSchedule("2024-11-04", List.of("12:30 PM", "6:00 PM", "8:30 PM"), List.of("2", "3", "1"));

        movies.get(3).addSchedule("2024-11-02", List.of("11:00 AM", "4:00 PM", "7:00 PM"), List.of("2", "3", "1"));
        movies.get(3).addSchedule("2024-11-05", List.of("3:00 PM", "6:00 PM", "10:00 PM"), List.of("1", "2", "4"));

        movies.get(4).addSchedule("2024-11-03", List.of("1:30 PM", "6:30 PM", "9:30 PM"), List.of("1", "2", "3"));
        movies.get(4).addSchedule("2024-11-06", List.of("12:00 PM", "5:00 PM", "8:00 PM"), List.of("2", "1", "3")); 

        movieList.addAll(movies);
        movieListView.setItems(movieList);
        setupListViewActions();
        movieListView.setCellFactory(param -> new ListCell<MovieDetails>() {
            @Override
            protected void updateItem(MovieDetails movie, boolean empty) {
                super.updateItem(movie, empty);
                if (empty || movie == null || movie.getTitle() == null) {
                    setText(null);
                } else {
                    setText(movie.getTitle());
                }
            }
        });
    }

    private void setupListViewActions() {
        movieListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                MovieDetails selectedMovie = movieListView.getSelectionModel().getSelectedItem();
                if (selectedMovie != null) {
                    loadMovieDetailsView(selectedMovie);
                }
            }
        });
    }

    private void loadMovieDetailsView(MovieDetails selectedMovie) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/oop_project3/movieDetails.fxml"));
            Parent movieDetailsRoot = loader.load();
            MovieDetailsController controller = loader.getController();
            controller.setSelectedMovie(selectedMovie);
            Stage stage = (Stage) movieListView.getScene().getWindow();
            stage.setScene(new Scene(movieDetailsRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addMovie(MovieDetails movie) {
        movieList.add(movie);
    }
}
