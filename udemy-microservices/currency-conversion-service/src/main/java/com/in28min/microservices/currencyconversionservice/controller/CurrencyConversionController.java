package com.in28min.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28min.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import com.in28min.microservices.currencyconversionservice.bean.ExchangeValue;
import com.in28min.microservices.currencyconversionservice.feign.CurrencyExchangeProxy;

/**
 * Main rest end-point for currency-conversion-service
 *
 * @author Aniket Bharsakale
 */
@RestController
@RequestMapping(value = "/currency-converter")
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	/**
	 * API: http://localhost:8100/currency-converter/from/AUD/to/INR/amount/1000
	 * 
	 * @param from is the source currency from which currency will be converted 
	 * @param to is the target currency into which currency will be converted
	 * @param amount to be calculated for 
	 * @return the total currency amount converted after using the currency exchange values
	 */
	@GetMapping(value = "/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionBean calculateGrossAmount(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal amount) {

		CurrencyConversionBean currencyBean = null;
		ExchangeValue exchangeValue = null;
		
		// Service invocation using Feign Rest Client
		exchangeValue = currencyExchangeProxy.retrieveExchangeValue(from, to);

		if (null != exchangeValue) {
			currencyBean = new CurrencyConversionBean();
			currencyBean.setTo(exchangeValue.getTo());
			currencyBean.setFrom(exchangeValue.getFrom());
			currencyBean.setId(exchangeValue.getId());
			currencyBean.setPort(exchangeValue.getAppPort());
			currencyBean.setConversionMultiple(exchangeValue.getConversionMultiple());
			currencyBean.setQuantity(amount);
			
			BigDecimal convertedResult = exchangeValue.getConversionMultiple().multiply(amount);
			currencyBean.setTotalCalculatedAmount(convertedResult);
		}
		
		logger.info("{}" + exchangeValue);

		return currencyBean;
	}
}
