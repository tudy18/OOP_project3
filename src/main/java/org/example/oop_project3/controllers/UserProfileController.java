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

    public void initData(User user) {
        this.user = user;
        loadUserData();
    }

    private void loadUserData() {
        fullNameLabel.setText(user.getUsername());
        emailLabel.setText(user.getEmail());
    }

    @FXML
    private void handleLogOut() {
        Stage stage = (Stage) fullNameLabel.getScene().getWindow();
        stage.close();
    }
}
