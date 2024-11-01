package org.example.oop_project3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.oop_project3.dao.UserDao;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {

    private Stage stage;
    private Scene scene;

    public PasswordField passwordField;
    public PasswordField confirmPasswordField;
    public TextField usernameField;
    public TextField emailField;

    public void handleRegister(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();


        if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill in all fields");
            return;
        }

        if(!password.equals(confirmPassword)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Passwords do not match");
            return;
        }

        if(UserDao.newUser(username, email, password)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("User created successfully");
            alert.showAndWait();

            goToLogin(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.showAndWait();
        }

    }
    public void goToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/oop_project3/login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleCancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText("Are you sure you want to cancel?");

        if(alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You have cancelled");
        }
    }
}
