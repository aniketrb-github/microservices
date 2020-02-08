package org.javabrains.ratingsdataservice.model;

import java.util.List;

public class UserRatingsTO {
	private List<Rating> ratingsList;

	public List<Rating> getRatingsList() {
		return ratingsList;
	}

	public void setRatingsList(List<Rating> ratingsList) {
		this.ratingsList = ratingsList;
	}
}
