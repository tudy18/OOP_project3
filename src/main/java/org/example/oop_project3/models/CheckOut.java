package org.example.oop_project3.models;

import javafx.fxml.FXML;

public class CheckOut
{
        private String cardholderName;
        @FXML
        private String cardNumber;
        private String expiryDate;
        private String cvvCode;

        public CheckOut(String cardholderName, String cardNumber, String expiryDate, String cvvCode) {
            this.cardholderName = cardholderName;
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
            this.cvvCode = cvvCode;
        }


}

