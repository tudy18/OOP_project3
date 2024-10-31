package org.example.oop_project3.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class User {

    private String username;
    private String password;
    private String email;
    private int userId;
    private String role;

    public User(String username, String password, String email, String role)
    {
        this.username=username;
        this.password=password;
        this.email=email;
        this.role=role;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role){this.role = role;}

    public String getRole(){return role;}
}
