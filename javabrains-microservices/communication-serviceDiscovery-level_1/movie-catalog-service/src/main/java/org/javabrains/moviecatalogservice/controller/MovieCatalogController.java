package org.javabrains.moviecatalogservice.controller;

import java.util.List;

import org.javabrains.moviecatalogservice.model.CatalogItem;
import org.javabrains.moviecatalogservice.model.UserRatingsTO;
import org.javabrains.moviecatalogservice.service.MovieInfoService;
import org.javabrains.moviecatalogservice.service.UserRatingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	private UserRatingInfoService userRatingsInfoService;
	
	@Autowired
	private MovieInfoService movieInfoService;
	
	// http://localhost:8081/catalog/{userId}

	/**
	 * This queries 2 microservices & returns a consolidated data back to client
	 * Hystrix Fallback mechanisms implemented for each independent microservice call at service layer
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {
		UserRatingsTO userRatingTO = userRatingsInfoService.getUserRating(userId);
		List<CatalogItem> catalogItems = movieInfoService.getMovieInfo(userRatingTO);
		return catalogItems;
	}

}
