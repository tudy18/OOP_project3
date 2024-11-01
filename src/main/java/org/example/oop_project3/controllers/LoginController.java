package org.example.oop_project3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.oop_project3.dao.UserDao;
import org.example.oop_project3.models.User;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    public TextField usernameField;
    public PasswordField passwordField;

    public void handleCancel(ActionEvent event) {
    }

    public void handleLogin(ActionEvent event)throws IOException {

            String username = usernameField.getText();
            String password = passwordField.getText();

            if(UserDao.login(username, password)){
                System.out.println("Login successful");
                User.setUsername(username);
                redirect(event);
            } else {
                System.out.println("Login failed");
            }
    }

    private void redirect(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/oop_project3/home.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }


}
