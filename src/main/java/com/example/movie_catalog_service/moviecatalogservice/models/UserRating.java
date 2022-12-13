package com.example.movie_catalog_service.moviecatalogservice.models;

import java.util.List;

public class UserRating {

    private List<Rating> ratings;
    private String userid;
    
    public UserRating() {
    }
    public UserRating(List<Rating> ratings, String userid) {
        this.ratings = ratings;
        this.userid = userid;
    }
    public List<Rating> getRatings() {
        return ratings;
    }
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    
}
