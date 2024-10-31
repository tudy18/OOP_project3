package org.example.oop_project3.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.oop_project3.models.User;

public class UserProfileController {

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label surnameLabel;

    @FXML
    private Label birthDateLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label countyLabel;

    @FXML
    private Label cityLabel;

    private User user;

    // Initializes with user data
    public void initData(User user) {
        this.user = user;
        loadUserData();
    }

    private void loadUserData() {
        // Assuming User has getters for these fields or methods to split into labels
        fullNameLabel.setText(user.getUsername());
        emailLabel.setText(user.getEmail());
        // Other data as per user object fields
        // surnameLabel.setText(user.getSurname());
        // birthDateLabel.setText(user.getBirthDate());
        // genderLabel.setText(user.getGender());
        // countyLabel.setText(user.getCounty());
        // cityLabel.setText(user.getCity());
    }

    @FXML
    private void handleLogOut() {
        // Close this stage
        Stage stage = (Stage) fullNameLabel.getScene().getWindow();
        stage.close();
    }
}
