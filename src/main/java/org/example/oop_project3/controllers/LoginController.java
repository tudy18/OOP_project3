package org.example.oop_project3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.oop_project3.models.User;

public class LoginController {
@FXML
private TextField usernameField;
@FXML
private PasswordField passwordField;
@FXML
private Button loginBtn;
User user;

    public void login(ActionEvent e){
        user.setUsername(usernameField.getText());
        user.setPassword(passwordField.getText());
    }
}
