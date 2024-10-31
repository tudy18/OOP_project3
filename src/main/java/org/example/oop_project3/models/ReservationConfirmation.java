package org.example.oop_project3.models;

public class ReservationConfirmation {

    public class Reservation {
        private String movieTitle;
        private int hall;
        private String seatNumber;
        private String customerName;
        private String date;
        private String time;


        public Reservation(String movieTitle, int hall, String seatNumber, String customerName, String date, String time) {
            this.movieTitle = movieTitle;
            this.hall = hall;
            this.seatNumber = seatNumber;
            this.customerName = customerName;
            this.date = date;
            this.time = time;
        }

        public String getMovieTitle() {
            return movieTitle;
        }

        public int getHall() {
            return hall;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }


        public void setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
        }

        public void setHall(int hall) {
            this.hall = hall;
        }

        public void setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Movie Title: " + movieTitle + "\n" +
                    "Hall: " + hall + "\n" +
                    "Seat Number: " + seatNumber + "\n" +
                    "Customer Name: " + customerName + "\n" +
                    "Date: " + date + "\n" +
                    "Time: " + time;
        }
    }
}





