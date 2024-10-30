package org.example.oop_project3.models;

public class SelectTickets
{
        private int adultTicketCount;
        private int childTicketCount;
        private int studentTicketCount;
        private String movieName;
        private String cinemaName;
        private String hall;
        private String format; // e.g., "2D" or "3D"
        private String date;
        private String time;

        public SelectTickets(String movieName, String cinemaName, String hall, String format, String date, String time)
        {
            this.movieName = movieName;
            this.cinemaName = cinemaName;
            this.hall = hall;
            this.format = format;
            this.date = date;
            this.time = time;


            this.adultTicketCount = 0;
            this.childTicketCount = 0;
            this.studentTicketCount = 0;
        }


        public int getAdultTicketCount()
        {
            return adultTicketCount;
        }

        public void setAdultTicketCount(int adultTicketCount)
        {
            this.adultTicketCount = adultTicketCount;
        }

        public int getChildTicketCount()
        {
            return childTicketCount;
        }

        public void setChildTicketCount(int childTicketCount)
        {
            this.childTicketCount = childTicketCount;
        }

        public int getStudentTicketCount()
        {
            return studentTicketCount;
        }

        public void setStudentTicketCount(int studentTicketCount)
        {
            this.studentTicketCount = studentTicketCount;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName)
        {
            this.movieName = movieName;
        }

        public String getCinemaName()
        {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName)
        {
            this.cinemaName = cinemaName;
        }

        public String getHall()
        {
            return hall;
        }

        public void setHall(String hall)
        {
            this.hall = hall;
        }

        public String getFormat()
        {
            return format;
        }

        public void setFormat(String format)
        {
            this.format = format;
        }

        public String getDate()
        {
            return date;
        }

        public void setDate(String date)
        {
            this.date = date;
        }

        public String getTime()
        {
            return time;
        }

        public void setTime(String time)
        {
            this.time = time;
        }


        public void increaseAdultTicketCount()
        {
            this.adultTicketCount++;
        }

        public void decreaseAdultTicketCount()
        {
            if (this.adultTicketCount > 0) {
                this.adultTicketCount--;
            }
        }

        public void increaseChildTicketCount()
        {
            this.childTicketCount++;
        }

        public void decreaseChildTicketCount()
        {
            if (this.childTicketCount > 0) {
                this.childTicketCount--;
            }
        }

        public void increaseStudentTicketCount()
        {
            this.studentTicketCount++;
        }

        public void decreaseStudentTicketCount()
        {
            if (this.studentTicketCount > 0) {

                this.studentTicketCount--;
            }
        }


        public int getTotalTickets()
        {
            return adultTicketCount + childTicketCount + studentTicketCount;
        }
}
