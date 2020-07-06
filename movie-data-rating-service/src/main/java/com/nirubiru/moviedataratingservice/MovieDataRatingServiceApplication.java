package com.nirubiru.moviedataratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieDataRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDataRatingServiceApplication.class, args);
		System.out.println("Movie data rating service running on port 8082");
	}

}
