package com.RatingsDataService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class MovieInfoService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MovieInfoService1Application.class, args);
	}

}
