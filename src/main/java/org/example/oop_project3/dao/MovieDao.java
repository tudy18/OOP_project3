package org.example.oop_project3.dao;

import org.example.oop_project3.models.MovieDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.oop_project3.utils.DatabaseConnection;
public class MovieDao {
    public static void saveMovie(MovieDetails movie) {
        String query = "INSERT INTO movies (title, genre, release_date, duration, image_path) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = new DatabaseConnection().connectToDatabase();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getGenre());
            stmt.setDate(3, Date.valueOf(movie.getReleaseDate()));
            stmt.setInt(4, movie.getDuration());
            stmt.setString(5, movie.getImagePath());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}