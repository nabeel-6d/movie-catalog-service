package com.example.movie_catalog_service.moviecatalogservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.movie_catalog_service.moviecatalogservice.models.Rating;
import com.example.movie_catalog_service.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {
    
      
    @Autowired
    private RestTemplate rest;
    
    @Autowired
    private UserRating user_Rating;
    
    @HystrixCommand(fallbackMethod = "getFallBackForUserRating")
    public UserRating getUserRatingItem(@PathVariable String userid){
        System.out.println("in catalog getuserrating mthod");
        user_Rating=rest.getForObject("http://Ratings-Data-Service/rating/user/"+userid,  UserRating.class);
        user_Rating.initRatingData(userid);
      return user_Rating;
    }

    public UserRating getFallBackForUserRating(@PathVariable String userid){
        user_Rating.setRatings(Arrays.asList(new Rating("no movie rated", 0)));
        return user_Rating;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rest == null) ? 0 : rest.hashCode());
        result = prime * result + ((user_Rating == null) ? 0 : user_Rating.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserRatingInfo other = (UserRatingInfo) obj;
        if (rest == null) {
            if (other.rest != null)
                return false;
        } else if (!rest.equals(other.rest))
            return false;
        if (user_Rating == null) {
            if (other.user_Rating != null)
                return false;
        } else if (!user_Rating.equals(other.user_Rating))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserRatingInfo [rest=" + rest + ", user_Rating=" + user_Rating + "]";
    }

    
}
