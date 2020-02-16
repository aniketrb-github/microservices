package com.in28min.microservices.limitsservice.bean;

/**
 * Model class for LimitConfiguration
 *
 * @author Aniket Bharsakale
 */
public class LimitConfiguration {
	private int minimum;
	private int maximum;

	public LimitConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public LimitConfiguration() {
		super();
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}

}
