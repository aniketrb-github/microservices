package org.arb_tech.controller;

import org.arb_tech.entity.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Entry point for Movie Resource, which acts as the Rest Controller 
 * @author Aniket Bharsakale
 */
@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	/**
	 * fetches movie info detail for a particular movieId from database
	 * @param movieId
	 * @return
	 */
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		// TODO: DB Connection to fetch movie data
		// hard coded data sent for time being excluding the JDBC/DB connection
		return new Movie(movieId, "Dummy HardCodeData Movie", "A movie of great posum !");
	}

}
