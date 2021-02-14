package com.RatingsDataService.Model;

public class Rating {
	
	 private String movieId;
	    private String rating;

	    public Rating(String movieId, String string) {
	        this.movieId = movieId;
	        this.rating = string;
	    }

	    public String getMovieId() {
	        return movieId;
	    }

	    public void setMovieId(String movieId) {
	        this.movieId = movieId;
	    }

	    public String getRating() {
	        return rating;
	    }

	    public void setRating(String rating) {
	        this.rating = rating;
	    }

}
