package org.javabrains.moviecatalogservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.javabrains.moviecatalogservice.model.CatalogItem;
import org.javabrains.moviecatalogservice.model.Movie;
import org.javabrains.moviecatalogservice.model.UserRatingsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Controller for Movie Catalog
 * 
 * @author Aniket Bharsakale
 *
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;
	
	// http://localhost:8081/catalog/14112

	@HystrixCommand(fallbackMethod = "getCatalogFallback") // Tells Hystrix to break circuits from this point
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {
		
		// Based on userId we get Ratings given by a user
		UserRatingsTO userRatingTO = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, 
				UserRatingsTO.class);
		
		List<CatalogItem> catalogItems = userRatingTO.getRatingsList()
				.stream()
				.map(rating -> 
								{ // For each rating, get its respective movie info
									Movie movie = restTemplate.getForObject("http://movie-info-service/movie/" + rating.getMovieId(), Movie.class);
									
									return new CatalogItem(movie.getName(), rating.getMovieRating(), movie.getDesc());
								}
								).collect(Collectors.toList());
		 
		
		return catalogItems;
	}
	
	public List<CatalogItem> getCatalogFallback(@PathVariable String userId) {
		return Arrays.asList(new CatalogItem("No Movie", 0, "No Movie Description"));
	}
}
