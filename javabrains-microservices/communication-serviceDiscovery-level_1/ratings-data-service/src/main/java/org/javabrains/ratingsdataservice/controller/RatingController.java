package org.javabrains.ratingsdataservice.controller;

import java.util.Arrays;

import org.javabrains.ratingsdataservice.model.Rating;
import org.javabrains.ratingsdataservice.model.UserRatingsTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller for MovieRatings given by User for his/her watched movies
 *  
 * @author Aniket Bharsakale
 */
@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

	// For a user, return all ratings for all his watched movies
	@GetMapping("/users/{userId}")
	public UserRatingsTO getRatingsList(@PathVariable String userId) {
		UserRatingsTO ratingsTO = new UserRatingsTO();
		ratingsTO.setRatingsList(Arrays.asList(new Rating(1523, 3.9f), new Rating(550, 4.6f)));
		return ratingsTO;
	}

}
