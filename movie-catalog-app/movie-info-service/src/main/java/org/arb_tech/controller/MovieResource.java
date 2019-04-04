package org.arb_tech.controller;

import org.arb_tech.entity.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		// call to DB to fetch the movie details for the movieId
		return new Movie(movieId, "Dummy HardCodeData Movie", "A movie of great posum !");
	}

}
