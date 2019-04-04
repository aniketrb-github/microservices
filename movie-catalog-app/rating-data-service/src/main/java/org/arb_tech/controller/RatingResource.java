package org.arb_tech.controller;

import java.util.Arrays;
import java.util.List;

import org.arb_tech.entity.Rating;
import org.arb_tech.entity.UserRatingVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRatingVO getUserRating (@PathVariable("userId") String userId) {
		List<Rating> ratingsList = Arrays.asList(
				new Rating("transformer_2018", 4),
				new Rating("bumblebee_2019", 5),
				new Rating("wonder_woman_2019", 2),
				new Rating("avengers-endgame_2019", 5));
		
		UserRatingVO userRatingVO = new UserRatingVO();
		userRatingVO.setUserRating(ratingsList);
		return userRatingVO;
	}

}
