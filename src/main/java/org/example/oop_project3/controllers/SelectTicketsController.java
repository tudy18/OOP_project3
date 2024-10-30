package org.example.oop_project3.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SelectTicketsController {

    @FXML
    private Label adultCount;
    @FXML
    private Label childCount;
    @FXML
    private Label studentCount;
    @FXML
    private Label totalPrice;

    private final double adultPrice = 50.0;
    private final double childPrice = 30.0;
    private final double studentPrice = 25.0;

    private int adultTickets = 0;
    private int childTickets = 0;
    private int studentTickets = 0;

    @FXML
    public void incrementAdult() {
        adultTickets++;
        adultCount.setText(String.valueOf(adultTickets));
        updateTotalPrice();
    }

    @FXML
    public void incrementChild() {
        childTickets++;
        childCount.setText(String.valueOf(childTickets));
        updateTotalPrice();
    }

    @FXML
    public void incrementStudent() {
        studentTickets++;
        studentCount.setText(String.valueOf(studentTickets));
        updateTotalPrice();
    }

    @FXML
    public void decrementAdult() {
        if (adultTickets > 0) {
            adultTickets--;
            adultCount.setText(String.valueOf(adultTickets));
            updateTotalPrice();
        }
    }

    @FXML
    public void decrementChild() {
        if (childTickets > 0) {
            childTickets--;
            childCount.setText(String.valueOf(childTickets));
            updateTotalPrice();
        }
    }

    @FXML
    public void decrementStudent() {
        if (studentTickets > 0) {
            studentTickets--;
            studentCount.setText(String.valueOf(studentTickets));
            updateTotalPrice();
        }
    }

    private void updateTotalPrice() {
        double total = (adultTickets * adultPrice) + (childTickets * childPrice) + (studentTickets * studentPrice);
        totalPrice.setText(String.format("%.2f", total));
    }


}
