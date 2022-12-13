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
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((movieid == null) ? 0 : movieid.hashCode());
            result = prime * result + rating;
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
            Rating other = (Rating) obj;
            if (movieid == null) {
                if (other.movieid != null)
                    return false;
            } else if (!movieid.equals(other.movieid))
                return false;
            if (rating != other.rating)
                return false;
            return true;
        }
        @Override
        public String toString() {
            return "Rating [movieid=" + movieid + ", rating=" + rating + "]";
        }
        
        
}
