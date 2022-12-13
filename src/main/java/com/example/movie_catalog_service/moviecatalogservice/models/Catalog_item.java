package com.example.movie_catalog_service.moviecatalogservice.models;

/**
 * Catalog_item
 */
public class Catalog_item {

    private String name;
    private String description;
    private int rating;
    
    public Catalog_item() {
    }
    public Catalog_item(String name, String description, int rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
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
        Catalog_item other = (Catalog_item) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (rating != other.rating)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Catalog_item [name=" + name + ", description=" + description + ", rating=" + rating + "]";
    }
    
}