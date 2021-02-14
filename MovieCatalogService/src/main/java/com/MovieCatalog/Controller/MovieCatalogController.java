package com.MovieCatalog.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.MovieCatalog.Model.CatalogItem;
import com.MovieCatalog.Model.Movie;
import com.MovieCatalog.Model.Rating;
import com.MovieCatalog.Model.UserRating;
import com.MovieCatalog.Service.MovieInfoService;
import com.MovieCatalog.Service.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MovieInfoService movieInfoService;
	
	@Autowired
	private UserRatingInfo userRatingInfo;
	
	
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{
		
		
		
		
		
		//get all rated movie IDs
		UserRating userRatings=userRatingInfo.getUserRating(userId);
		
		/*
		 * return ratings.stream().map(rating-> { Movie
		 * movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.
		 * getMovieId(), Movie.class); return new CatalogItem("Desc" movie.getName(),
		 * rating.getRating()); }).collect(Collectors.toList());
		 */
		
		List<CatalogItem>list=new ArrayList<>();
		for(Rating rating:userRatings.getUserRating())
		{
			
			//for each movie ID ,call movie info service and  get details
			
			try
			{
			list.add(movieInfoService.getCatalogItem(rating));
			}
			
			catch(Exception e)
			{
				System.out.println("Error in api call");
			}
		}
		
		return list;
		
		
		
		
		
		
		
		
		
		
		
		
	}



	
	
	
	



	
	
	
	
	
	
	

}
