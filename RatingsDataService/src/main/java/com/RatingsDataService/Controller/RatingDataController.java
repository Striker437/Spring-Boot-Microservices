package com.RatingsDataService.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RatingsDataService.Model.Rating;
import com.RatingsDataService.Model.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingDataController {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId,"4");
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId)
	{
		List<Rating> ratings=Arrays.asList(new Rating("1234","4"),
                new Rating("5678","3"),
                new Rating("100","3"),
                new Rating("200","4"));
		
		UserRating userRating=new UserRating();
		userRating.setUserRating(ratings);
		
		return userRating;
	}

}
