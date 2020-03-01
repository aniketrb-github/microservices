package org.javabrains.moviecatalogservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.javabrains.moviecatalogservice.model.CatalogItem;
import org.javabrains.moviecatalogservice.model.Movie;
import org.javabrains.moviecatalogservice.model.UserRatingsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * Service class impl. for Movie Info
 * 
 * @author Aniket Bharsakale
 */

@Service
public class MovieInfoService {
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * This queries the 'movie-info-service' & gets the movie-info data
	 * @param userRatingTO
	 * @return
	 */
	@HystrixCommand(
			fallbackMethod = "getMovieInfoFallback", 
			threadPoolKey = "movieInfoPool", 
			threadPoolProperties = {
						@HystrixProperty(name = "coreSize", value = "20"), 
						@HystrixProperty(name = "maxQueueSize", value = "10") 
									})
	public List<CatalogItem> getMovieInfo(UserRatingsTO userRatingTO) {
		List<CatalogItem> catalogItems = userRatingTO.getRatingsList()
				.stream()
				.map(rating -> { // For each rating, get its respective movie info
									Movie movie = restTemplate.getForObject("http://movie-info-service/movie/" + rating.getMovieId(), Movie.class);
									
									return new CatalogItem(movie.getName(), rating.getMovieRating(), movie.getDesc());
								}
								).collect(Collectors.toList());
		return catalogItems;
	}
	
	/**
	 * 
	 * This fallback method executes only if the 'movie-info-service' is down 
	 * or does not return a response within expected time
	 * 
	 * @param userRatingTO containing the user ratings for all the movies he has watched.
	 * @return List of Catalog Items of consolidated data with Ratings data
	 */
	public List<CatalogItem> getMovieInfoFallback(UserRatingsTO userRatingTO) {
		// Here, we're extracting the User's Movie ratings into a special List of Ratings only
		List<Float> ratings = userRatingTO.getRatingsList().stream().map(e -> e.getMovieRating() ).collect(Collectors.toList());
		
		// For each extracted rating value, we're creating new CatalogItem object & return that list of objects 
		return ratings.stream()
				.map(e -> new CatalogItem("No Movie Name Found!", e.floatValue(), "No Movie Description found!"))
				.collect(Collectors.toList());
	}
 

}
