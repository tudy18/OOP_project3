package org.example.oop_project3.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDetails extends Movie {

    private Map<String, List<String>> timesByDate;
    private Map<String, List<String>> hallsByDate;
    private String format;
    public MovieDetails(String title, String genre, String releaseDate, String imagePath, String description, int duration,  String format) {
        super(title, genre, releaseDate, imagePath, description, duration);
        this.timesByDate = new HashMap<>();
        this.hallsByDate = new HashMap<>();
        this.format=format;
    }

    public void addSchedule(String date, List<String> times, List<String> halls) {
        if (times.size() != halls.size()) {
            throw new IllegalArgumentException("Each time must correspond to a hall.");
        }
        timesByDate.put(date, times);
        hallsByDate.put(date, halls);
    }

    public List<String> getTimesForDate(String date) {
        return timesByDate.get(date);
    }

    public List<String> getHallsForDate(String date) {
        return hallsByDate.get(date);
    }

    public Map<String, List<String>> getTimesByDate() {
        return timesByDate;
    }

    public Map<String, List<String>> getHallsByDate() {
        return hallsByDate;
    }
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


}
