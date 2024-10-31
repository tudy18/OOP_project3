package org.example.oop_project3.controllers;

import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import org.example.oop_project3.models.MovieDetails;

public class MovieCellController extends ListCell<MovieDetails> {

    private final VBox vbox;

    public MovieCellController() {
        vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
    }

    @Override
    protected void updateItem(MovieDetails movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setGraphic(null);
            setText(null);
        } else {
            vbox.getChildren().clear();

            ImageView imageView = new ImageView();
            try {
                Image image = new Image(getClass().getResourceAsStream(movie.getImagePath()));
                imageView.setImage(image);
            } catch (Exception e) {
                // System.err.println("Error loading image: " + e.getMessage());
            }
            Text titleText = new Text(movie.getTitle());
            titleText.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: black;");
            vbox.getChildren().addAll(imageView, titleText);
            setGraphic(vbox);
        }
    }
}
