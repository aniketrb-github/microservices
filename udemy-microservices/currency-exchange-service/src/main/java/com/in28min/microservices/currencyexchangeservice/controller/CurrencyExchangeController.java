package com.in28min.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28min.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.in28min.microservices.currencyexchangeservice.repository.ExchangeValueService;

/**
 * Main restful end-point for currency-exchange-service
 *
 * @author Aniket Bharsakale
 */
@RestController
@RequestMapping(value = "/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueService exchangeValueService;

	/**
	 * Res web-service to get the currency exchange value(ex: from EUR to INR)
	 * 
	 * API: http://localhost:8001/currency-exchange/from/EUR/to/INR
	 * API: http://localhost:8000/currency-exchange/from/EUR/to/INR
	 * 
	 * added VM argument: -Dserver.port=8001 in RunConfiguration to trigger multiple instances of same service
	 * 
	 * @param from is the source currency from which currency will be converted 
	 * @param to is the target currency into which currency will be converted
	 * @return the currency-exchange-model object
	 */
	@GetMapping(value = "/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue value = null;
		value = exchangeValueService.retrieveExchangeValue(from, to);
		
		// value = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		
		value.setAppPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return value;
	}
}
