package com.nirubiru.moviecatalogservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.nirubiru.moviecatalogservice.model.CatelogItem;
import com.nirubiru.moviecatalogservice.model.Movie;
import com.nirubiru.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userid}")
	List<CatelogItem> getCatelog(@PathVariable("userid") String userId) {

		// RestTemplate restTemplate = new RestTemplate();

		// get all rated movie ids.

//		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("5678", 3));

		/*UserRating userRating = restTemplate.getForObject("http://localhost:8082/ratingsdata/user/" + userId,
				UserRating.class);*/
		UserRating userRating = restTemplate.getForObject("http://data-rating-service/ratingsdata/user/" + userId,
				UserRating.class);
		
		

		return userRating.getUserRating().stream().map(rating -> {
			// This is the sysnchronous way to calling the uri
			// For each movie id, call movie info service and get details.
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

			// This is the asysnchronous way to calling the uri
			/*
			 * Movie movie = WebClientBuilder.build() .get()
			 * .uri("http://localhost:8083/movies/"+rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
			// Put them all together.
			return new CatelogItem(movie.getMovieName(), movie.getDescription(), rating.getRating());
		}

		).collect(Collectors.toList());

		

		

//		return Collections.singletonList(new CatelogItem("Transformer", "very fantastic movie", "4"));
	}

}
