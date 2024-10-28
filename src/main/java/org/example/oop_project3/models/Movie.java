package org.example.oop_project3.models;
public class Movie {
    private String title;
    private String genre;
    private String releaseDate;
    private String imagePath;
    private String description;


    public Movie(String title, String genre, String releaseDate, String imagePath, String description) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.imagePath = imagePath;
        this.description=description;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() { return genre; }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

