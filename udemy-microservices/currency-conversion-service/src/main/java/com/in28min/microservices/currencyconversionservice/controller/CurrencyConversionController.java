package com.in28min.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28min.microservices.currencyconversionservice.bean.ConvertedCurrency;
import com.in28min.microservices.currencyconversionservice.bean.ExchangeValue;

/**
 * Main rest end-point for currency-conversion-service
 *
 * @author Aniket Bharsakale
 */
@RestController
@RequestMapping(value = "/currency-converter")
public class CurrencyConversionController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/from/{from}/to/{to}/amount/{amount}")
	public ConvertedCurrency calculateGrossAmount(@PathVariable String from, @PathVariable String to,
			@PathVariable Double amount) {

		// http://localhost:8000/currency-exchange/from/USD/to/INR
		ConvertedCurrency convertedCurrency = null;
		
		ExchangeValue exchangeValue = restTemplate.getForObject(
				"http://currency-exchange-service/currency-exchange/from/" + from + "/to/" + to, ExchangeValue.class);

		if (null != exchangeValue) {
			convertedCurrency = new ConvertedCurrency();
			convertedCurrency.setTo(exchangeValue.getTo());
			convertedCurrency.setFrom(exchangeValue.getFrom());
			convertedCurrency.setId(exchangeValue.getId());
			Double convertedResult = exchangeValue.getConversionMultiple().doubleValue() * amount;
			convertedCurrency.setConvertedCurrency(BigDecimal.valueOf(convertedResult));
		}

		return convertedCurrency;
	}
}
