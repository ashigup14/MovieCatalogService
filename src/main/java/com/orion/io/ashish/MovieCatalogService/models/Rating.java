package com.orion.io.ashish.MovieCatalogService.models;

public class Rating {

    private String movieiD;
    private int rating;

    public Rating() {
    }

    public Rating(String movieiD, int rating) {
        this.movieiD = movieiD;
        this.rating = rating;
    }

    public String getMovieiD() {
        return movieiD;
    }

    public void setMovieiD(String movieiD) {
        this.movieiD = movieiD;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
