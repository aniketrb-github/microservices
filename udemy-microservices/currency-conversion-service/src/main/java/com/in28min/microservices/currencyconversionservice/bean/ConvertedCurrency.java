package com.in28min.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

/**
 * The ConvertedCurrency model class
 *
 * @author Aniket Bharsakale
 */
public class ConvertedCurrency {
	private Long id;
	private String from;
	private String to;
	private BigDecimal convertedCurrency;

	public ConvertedCurrency(Long id, String from, String to, BigDecimal convertedCurrency) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertedCurrency = convertedCurrency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConvertedCurrency() {
		return convertedCurrency;
	}

	public void setConvertedCurrency(BigDecimal convertedCurrency) {
		this.convertedCurrency = convertedCurrency;
	}

	public ConvertedCurrency() {
		super();
	}
}
