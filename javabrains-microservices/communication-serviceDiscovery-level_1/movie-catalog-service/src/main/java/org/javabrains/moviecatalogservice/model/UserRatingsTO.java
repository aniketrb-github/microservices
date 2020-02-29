package org.javabrains.moviecatalogservice.model;

import java.util.List;

/**
 * acts as the transfer object for view layer
 * 
 * @author Aniket Bharsakale
 */
public class UserRatingsTO {
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private List<Rating> ratingsList;

	public List<Rating> getRatingsList() {
		return ratingsList;
	}

	public void setRatingsList(List<Rating> ratingsList) {
		this.ratingsList = ratingsList;
	}

	public UserRatingsTO(Long userId, List<Rating> ratingsList) {
		super();
		this.userId = userId;
		this.ratingsList = ratingsList;
	}
	
	public UserRatingsTO() {
	}

}
