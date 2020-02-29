package org.javabrains.moviecatalogservice.service;

import java.util.Arrays;

import org.javabrains.moviecatalogservice.model.Rating;
import org.javabrains.moviecatalogservice.model.UserRatingsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
/**
 * Service class impl for User Ratings for a Movie
 * 
 * @author Aniket Bharsakale
 */
@Service
public class UserRatingInfoService {
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * This queries the 'ratings-data-service' & gets the movie ratings given by a user
	 * 
	 * @param userId is the user identifier
	 * @return userRatingTO containing the user ratings for all the movies he has watched.
	 */
	@HystrixCommand(fallbackMethod = "getUserRatingFallback")
	public UserRatingsTO getUserRating(@PathVariable("userId") String userId) {
		UserRatingsTO userRatingsTO = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRatingsTO.class);
		return userRatingsTO;
	}

	/**
	 * 
	 * This fallback method executes only if the 'rating-data-service' is down 
	 * or does not return a response within expected time
	 * 
	 * @param userId is the user identifier
	 * @return userRatingTO containing the user ratings for all the movies he has watched.
	 */
	public UserRatingsTO getUserRatingFallback(@PathVariable("userId") String userId) {
		return new UserRatingsTO(Long.parseLong(userId), Arrays.asList(new Rating(44444, 99999)));
	}
}
