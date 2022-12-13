package com.example.movie_catalog_service.moviecatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.movie_catalog_service.moviecatalogservice.models.Catalog_item;
import com.example.movie_catalog_service.moviecatalogservice.models.Movie;
import com.example.movie_catalog_service.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MoviesInfo {
    
    @Autowired
    private RestTemplate rest;

    @HystrixCommand(fallbackMethod = "getFallBackForCatalog_item")
    public Catalog_item getCatalogItem(Rating rating) {
        System.out.println("in catalog getcatalog mthod");
        Movie movie = rest.getForObject("http://MOVIES-INFO-SERVICE/movie/"+rating.getMovieid(), Movie.class);
        System.out.println("after getForObject ratings data -catalog get mthod");
      return new Catalog_item(movie.getName(), movie.getDescription(), rating.getRating());
    }

    public Catalog_item getFallBackForCatalog_item(Rating rating){
        return new Catalog_item("no movie", "", rating.getRating());
    }
}
