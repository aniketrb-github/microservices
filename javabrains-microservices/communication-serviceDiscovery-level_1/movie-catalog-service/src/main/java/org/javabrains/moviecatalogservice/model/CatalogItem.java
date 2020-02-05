package org.javabrains.moviecatalogservice.model;

public class CatalogItem {

	private String movieName;
	private float movieRating;
	private String movieDescription;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public float getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public CatalogItem(String movieName, float movieRating, String movieDescription) {
		super();
		this.movieName = movieName;
		this.movieRating = movieRating;
		this.movieDescription = movieDescription;
	}

	public CatalogItem() {
	}

}
