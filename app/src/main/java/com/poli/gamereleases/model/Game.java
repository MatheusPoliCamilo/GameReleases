package com.poli.gamereleases.model;

public class Game {

    private String title;
    private String releaseDate;
    private String imageURL;

    public Game() {}

    public Game(String title, String releaseDate, String image) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.imageURL = image;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
