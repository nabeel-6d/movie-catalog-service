package com.example.movie_catalog_service.moviecatalogservice.models;

public class Rating {
        private String movieid;
        private int rating;
    
    
        public Rating() {
        }
        public Rating(String movieid, int rating){
            this.movieid = movieid;
            this.rating = rating;
        }
        public String getMovieid() {
            return movieid;
        }
        public void setMovieid(String movieid) {
            this.movieid = movieid;
        }
        public int getRating() {
            return rating;
        }
        public void setRating(int rating) {
            this.rating = rating;
        }
        
}
