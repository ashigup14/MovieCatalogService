package com.orion.io.ashish.MovieCatalogService.models;

import java.util.ArrayList;
import java.util.List;

public class UserRating {

    private List<Rating> userRatings = new ArrayList<>();

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

}
