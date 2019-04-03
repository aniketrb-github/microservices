package org.arb_tech.controller;

import java.util.Collections;
import java.util.List;

import org.arb_tech.entity.CatalogItem;
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
		
		return Collections.singletonList(new CatalogItem("Transformers", "The War of Robots", 4));
	}
}
