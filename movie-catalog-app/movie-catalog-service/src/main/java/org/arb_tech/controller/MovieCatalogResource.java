package org.arb_tech.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.arb_tech.entity.CatalogItem;
import org.arb_tech.entity.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	/**
	 * Controller which returns a list of Movie Catalog Resources
	 * @param userId
	 * @return
	 */
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		// initially we're sending some hard-coded data for time-being since no DB is attached
		// ideally, fetch the data from database of this service for the requested 'userId'
		
		// step1: initially, get all rated movieId's for the requested userId
		// step2: forEach movieId call the movie info service & get movieDetails
		// step3: compose s1 & s2 together & return the consolidated data back 
		
		
		// step1
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 5));
		
		// step2: 
		ratings.stream().map(rating -> new CatalogItem("Transformer", "War of Robots", 4)).collect(Collectors.toList());
		
		return Collections.singletonList(new CatalogItem("Transformers", "The War of Robots", 4));
	}
}
