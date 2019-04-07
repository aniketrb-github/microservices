package org.arb_tech.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.arb_tech.entity.CatalogItem;
import org.arb_tech.entity.Movie;
import org.arb_tech.entity.UserRatingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * MovieCatalogResource acts as the controller for movie-catalog-service
 * It invokes movie-info-service which returns a movieList viewed by a particular user.
 * For each movie, then ratings-data-service is invoked to get the movie ratings by that same user.
 * Finally, a consolidated result from the 2 micro-services is sent ahead by movie-catalog-service.
 * @author Aniket Bharsakale
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	/**
	 * Controller which returns a list of Movie Catalog Resources
	 * @param userId
	 * @return
	 */
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		// s1: get movieList for requested userId by invoking the movie-info-service
		// s2: get ratings for each movie by invoking the ratings-data-service
		// step3: compose s1 & s2 together & return the consolidated data back
		
		UserRatingVO userRatingVO = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRatingVO.class);

		return userRatingVO.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
	}
	
	/* Using WebClient instead of RestTempalte
	 Movie movie = webClientBuilder.build()
			.get()
			.uri("http://localhost:18082/movies/" + rating.getMovieId())
			.retrieve().bodyToMono(Movie.class)
			.block();
	*/
}
