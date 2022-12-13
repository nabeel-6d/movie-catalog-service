package com.example.movie_catalog_service.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.movie_catalog_service.moviecatalogservice.models.Catalog_item;
import com.example.movie_catalog_service.moviecatalogservice.models.Movie;
import com.example.movie_catalog_service.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class Catalog_Movie_Resource {
    /*somebody(user) wants to see what all movies he/she have watched and rated
    so user goes to this url 
    he should see a list of movies that he/she watched and rated

    -------------------------
     so i have to create a getter method that sends a list of all the movies based on user id  
     * 
     */
     @Autowired
     private RestTemplate rest;

     @GetMapping("/{userid}")
     public List<Catalog_item> getmovies(@PathVariable String userid){
       try {
        System.out.println("in catalog get mthod");
        UserRating user_rating=rest.getForObject("http://Ratings-Data-Service/rating/user/"+userid,  UserRating.class);
        System.out.println("after getForObject ratings data -catalog get mthod");
        return user_rating.getRatings().stream()
                .map(rating -> {
                    Movie movie = rest.getForObject("http://MOVIES-INFO-SERVICE/movie/"+rating.getMovieid(), Movie.class);
                    System.out.println("after getForObject ratings data -catalog get mthod");
                    return new Catalog_item(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());
       }
       catch(Exception e) {
        System.out.println("------------------------------------------------------");
        System.out.println();
        e.printStackTrace();
        System.out.println();
        System.out.println("--------------------------------------------------------");
       }
       return null;
     }
}
