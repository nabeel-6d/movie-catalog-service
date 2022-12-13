package com.example.movie_catalog_service.moviecatalogservice.models;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
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

    public void initRatingData(String id){
        this.setUserid(id);
        this.setRatings(Arrays.asList(new Rating("200", 4),new Rating("300", 6),new Rating("425", 7)));
    }
   
    @Override
    public String toString() {
        return "UserRating [ratings=" + ratings + ", userid=" + userid + "]";
    }
    
}
