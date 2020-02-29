package org.javabrains.movieinfoservice.controller;

import org.javabrains.movieinfoservice.model.Movie;
import org.javabrains.movieinfoservice.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * The Movie Rest Controller
 * @author Aniket Bharsakale
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
    private Environment environment;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable int movieId) {
		MovieSummary movieSummary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + environment.getProperty("api.key"), MovieSummary.class);
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}
}
