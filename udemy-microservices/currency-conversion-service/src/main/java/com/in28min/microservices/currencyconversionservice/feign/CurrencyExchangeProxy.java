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

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
//@FeignClient(name = "currency-exchange-service", URL = "localhost:8000")
public interface CurrencyExchangeProxy {

	/**
	 * @RibbonClient
	 * name: is the name of the target micro-service with which communication is to be done.
	 * URL : is the URL on which the target micro-service is hosted upon
	 * 
	 * @FeignClient this Proxy will communicate with ZUUL API Gateway server
	 * i.e. when the endpoint of CCS is invoked then 
	 * the Routing will happen as follows: 
	 * endUser -> CCS -> ZUUL -> EUREKA -> CES -> CCS -> endUser 
	 */
	
	
	/**
	 * Below is the copied-pasted method signature from the CES
	 * Its the rest end-point with which we will be communicating from CCS
	 */
	@GetMapping(value = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
