package com.example.movie_catalog_service.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_catalog_service.moviecatalogservice.models.Catalog_item;
import com.example.movie_catalog_service.moviecatalogservice.services.MoviesInfo;
import com.example.movie_catalog_service.moviecatalogservice.services.UserRatingInfo;

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
     private MoviesInfo moviesinfo;

     @Autowired
     private UserRatingInfo userRatingInfo;

     @GetMapping("/{userid}")
     public List<Catalog_item> getmovies(@PathVariable String userid){
       try {
        System.out.println("getting in the getmovies() ");
        userRatingInfo.getUserRatingItem(userid).getRatings().stream()
                .map(rating -> {
                    return moviesinfo.getCatalogItem(rating);
                })
                .collect(Collectors.toList());
                System.out.println("getting out the getmovies() "+userRatingInfo);
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
/*
 * providing the methods that call other apis in a different class for the hystrix to work its proxy class implementation
 */