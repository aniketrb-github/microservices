package com.in28min.microservices.currencyconversionservice.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28min.microservices.currencyconversionservice.bean.ExchangeValue;

/**
 * Feign Proxy is used to communicate with other micro-services.
 * Its just like the Rest-Template, but reduces a lot of boiler plate code.
 * Conceptually its also similar to the JPARepository interface which allows us to transact with a database 
 *
 * @author Aniket Bharsakale
 */

// @FeignClient(name = "currency-exchange-service", url = "localhost:8000")
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

	/**
	 * name: is the name of the target micro-service with which communication is to be done.
	 * url : is the URL on which the target micro-service is hosted upon
	 *  
	 */
	
	
	/**
	 * Below is the copied-pasted method signature from the 'currency-exchange-service' - rest end-point with which we will be communicating
	 */
	@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
