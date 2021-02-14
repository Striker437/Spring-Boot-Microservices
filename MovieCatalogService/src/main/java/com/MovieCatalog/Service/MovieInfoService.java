package com.MovieCatalog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.MovieCatalog.Model.CatalogItem;
import com.MovieCatalog.Model.Movie;
import com.MovieCatalog.Model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class MovieInfoService {
	
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "getfallBackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);
		
		//put them all together
		return new CatalogItem(movie.getDescription(), movie.getName(), rating.getRating());
		
	}
	
	
	public CatalogItem getfallBackCatalogItem(Rating rating) {
		
		return new CatalogItem ("Movie name not found" ,"",rating.getRating());
	}

}
