package com.in28min.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

/**
 * Model class for Currency Exchange value
 *
 * @author Aniket Bharsakale
 */
public class ExchangeValue {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private int appPort;

	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
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

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getAppPort() {
		return appPort;
	}

	public void setAppPort(int appPort) {
		this.appPort = appPort;
	}

	public ExchangeValue() {
		super();
	}	
}
