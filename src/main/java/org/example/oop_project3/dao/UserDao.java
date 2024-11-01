package org.example.oop_project3.dao;

import org.example.oop_project3.utils.dbConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public static boolean newUser(
            String username,
            String email,
            String password
    ) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try (Connection connection = new dbConnection().connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, hashedPassword);

            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean login(
            String username,
            String password
    ) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = new dbConnection().connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("User not found");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void logout(){
        System.out.println("Logged out");
    }

}
