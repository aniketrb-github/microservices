package org.javabrains.ratingsdataservice.model;

public class Rating {
	private int movieId;
	private float movieRating;

	public Rating(int movieId, float movieRating) {
		this.movieId = movieId;
		this.movieRating = movieRating;
	}

	public float getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Rating() {
	}
}