package com.MovieCatalog.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.MovieCatalog.Model.Rating;
import com.MovieCatalog.Model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class UserRatingInfo {
	
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getfallBackUserRating")
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratings/users/"+userId,UserRating.class );
	}
	
	
	
	public UserRating getfallBackUserRating(String userId) {
		UserRating userRating=new UserRating();
		userRating.setUserId(userId);
		userRating.setUserRating(Arrays.asList(new Rating("0" ,"0"))
				
				
				);
		return userRating;
	}
	

}
