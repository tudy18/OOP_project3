package org.example.oop_project3;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Circle circle;
    private double x;
    private double y;
    public void up(ActionEvent e){
        circle.setCenterY(y--);
    }

    public void down(ActionEvent e){
        circle.setCenterY(y++);
    }

    public void left(ActionEvent e){
        circle.setCenterX(x--);
    }

    public void right(ActionEvent e){
        circle.setCenterX(x++);
    }
}