package com.in28min.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28min.microservices.currencyexchangeservice.bean.ExchangeValue;

/**
 * Main restful end-point for currency-exchange-service
 *
 * @author Aniket Bharsakale
 */
@RestController
@RequestMapping(value = "/currency-exchange")
public class CurrencyExchangeController {

	@GetMapping(value = "/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		return new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
	}
}
