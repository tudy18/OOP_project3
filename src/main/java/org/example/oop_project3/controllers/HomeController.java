
package org.example.oop_project3.controllers;
import java.sql.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.oop_project3.models.MovieDetails;
import org.example.oop_project3.utils.dbConnection;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
public class HomeController {
    @FXML
    private ListView<MovieDetails> movieListView;
    private ObservableList<MovieDetails> movieList;

    public HomeController() {
      movieList = FXCollections.observableArrayList();
    }

    @FXML
    private void initialize() {
        movieListView.setCellFactory(listView -> new MovieCellController());

        refreshMovies();
        setupListViewActions();
    }

    public void refreshMovies() {
        movieList.clear();
        String query = "SELECT title, genre, release_date, duration, image_path, description, format FROM movies";

        try (Connection conn = new dbConnection().connectToDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                MovieDetails movie = new MovieDetails(
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getDate("release_date").toString(),
                        rs.getString("image_path"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getString("format")
                );
                movieList.add(movie);
            }
            movieListView.setItems(movieList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

@FXML
    private void openAddMovie()
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/oop_project3/addMovie.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            AddMovieController controller = new AddMovieController();
            controller.setHomeController(this);
            loader.setController(controller);


            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void insertMoviesWithSchedules(List<MovieDetails> movies) {
        String movieInsertQuery = "INSERT INTO movies (title, genre, release_date, image, description, duration, format) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String scheduleInsertQuery = "INSERT INTO schedules (movie_id, schedule_date, show_time, screen_number) VALUES (?, ?, ?, ?)";

        try (Connection conn = new dbConnection().connectToDatabase()) {
            conn.setAutoCommit(false);

            for (MovieDetails movie : movies) {
                try (PreparedStatement movieStmt = conn.prepareStatement(movieInsertQuery, Statement.RETURN_GENERATED_KEYS)) {
                    movieStmt.setString(1, movie.getTitle());
                    movieStmt.setString(2, movie.getGenre());
                    movieStmt.setString(3, movie.getReleaseDate());

                    // Assuming the image path is stored in MovieDetails and you have access to it.
                    byte[] imageBytes = Files.readAllBytes(Paths.get(movie.getImagePath()));
                    movieStmt.setBytes(4, imageBytes);

                    movieStmt.setString(5, movie.getDescription());
                    movieStmt.setInt(6, movie.getDuration());
                    movieStmt.setString(7, movie.getFormat());
                    movieStmt.executeUpdate();

                    ResultSet generatedKeys = movieStmt.getGeneratedKeys();
                    int movieId = 0;
                    if (generatedKeys.next()) {
                        movieId = generatedKeys.getInt(1);
                    }

                    for (String date : movie.getTimesByDate().keySet()) {
                        List<String> times = movie.getTimesForDate(date);
                        List<String> halls = movie.getHallsForDate(date);

                        for (int i = 0; i < times.size(); i++) {
                            try (PreparedStatement scheduleStmt = conn.prepareStatement(scheduleInsertQuery)) {
                                scheduleStmt.setInt(1, movieId);
                                scheduleStmt.setDate(2, Date.valueOf(date));
                                scheduleStmt.setTime(3, Time.valueOf(times.get(i)));
                                scheduleStmt.setString(4, halls.get(i));
                                scheduleStmt.executeUpdate();
                            }
                        }
                    }
                }
            }

            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
