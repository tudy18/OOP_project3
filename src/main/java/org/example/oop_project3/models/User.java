package org.example.oop_project3.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class User {
    private static String username;
    private String password;
    private String email;
    public User(String username, String password, String email)
    {
        User.username=username;
        this.password=password;
        this.email=email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public String getEmail() {
        return email;
    }
}
