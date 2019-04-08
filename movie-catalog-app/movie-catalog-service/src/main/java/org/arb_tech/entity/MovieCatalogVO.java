package org.arb_tech.entity;

import java.util.List;

public class MovieCatalogVO {

	private List<CatalogItem> movieCatalogItems;

	public List<CatalogItem> getMovieCatalogItems() {
		return movieCatalogItems;
	}

	public void setMovieCatalogItems(List<CatalogItem> movieCatalogItems) {
		this.movieCatalogItems = movieCatalogItems;
	}
}
