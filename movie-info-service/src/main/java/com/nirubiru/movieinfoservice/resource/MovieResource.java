package com.nirubiru.movieinfoservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nirubiru.movieinfoservice.model.Movie;
import com.nirubiru.movieinfoservice.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@Value("${api.key}")
	private String api_key;

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieid) {
		//return new Movie(movieid, "Transformer2");
		//https://api.themoviedb.org/3/movie/550?api_key=4a0f542fae1a13a3f94a3c211e2540e1
		//https://api.themoviedb.org/3/movie/100?api_key=4a0f542fae1a13a3f94a3c211e2540e1
		MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieid+"?apiKey="+api_key, MovieSummary.class);
		return new Movie(movieid,movieSummary.getTitle(), movieSummary.getOverview());
	}

}
