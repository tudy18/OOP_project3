package org.example.oop_project3.controllers;

public class CheckOut
{
        private String cardholderName;
        private String cardNumber;
        private String expiryDate;
        private String cvvCode;

        public CheckOut(String cardholderName, String cardNumber, String expiryDate, String cvvCode) {
            this.cardholderName = cardholderName;
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
            this.cvvCode = cvvCode;
        }

        public String getCardholderName() {
            return cardholderName;
        }

        public void setCardholderName(String cardholderName) {
            this.cardholderName = cardholderName;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }

        public String getCvvCode() {
            return cvvCode;
        }

        public void setCvvCode(String cvvCode) {
            this.cvvCode = cvvCode;
        }

        @Override
        public String toString() {
            return "Payment{" +
                    "Cardholder Name='" + cardholderName + '\'' +
                    ", Card Number='" + cardNumber + '\'' +
                    ", Expiry Date='" + expiryDate + '\'' +
                    ", CVV='" + cvvCode + '\'' +
                    '}';
        }
}

