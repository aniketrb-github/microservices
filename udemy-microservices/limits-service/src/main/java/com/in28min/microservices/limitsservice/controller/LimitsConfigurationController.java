package com.in28min.microservices.limitsservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28min.microservices.limitsservice.bean.LimitConfiguration;
import com.in28min.microservices.limitsservice.config.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Rest controller for LimitConfiguration
 *
 * @author Aniket Bharsakale
 */
@RestController
@RequestMapping(value = "/limits")
public class LimitsConfigurationController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMinimum(),
				configuration.getMaximum());
		logger.info("{}" + configuration);
		return limitConfiguration;
	}
	
	@GetMapping("/fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallbackGetConfiguration")
	public LimitConfiguration getConfiguration () {
		throw new RuntimeException("Service Not Available!");
	}
	
	/**
	 * Fault Tolerant fall-back - backup method.
	 * Say, GET:getConfiguration() is down/failed/breaking due to some reason at runtime.
	 * Even after its breaking, we will be providing a graceful response back to those
	 * client micro-services with a default usable response so that they can keep working without blockage 
	 */
	public LimitConfiguration fallbackGetConfiguration () {
		return new LimitConfiguration(9, 999);
	}
	
	
	/*
	 * Spring Cloud Bus concept
	 * 
	Here, each time u have to execute /actuator/refresh for each instance i.e 8080, 8081, 8082 etc . . .
	So as to make all instances of the limits-service in sync with the changes done in the Git Repo
	POST: http://localhost:8080/actuator/refresh
	GET : http://localhost:8080/limits
	
	POST: http://localhost:8081/actuator/refresh
	GET: http://localhost:8081/limits
	
	POST: http://localhost:8082/actuator/refresh
	GET: http://localhost:8082/limits
	-------------------------------------------------------------------------------
	// This will refresh the cache of all instances of limits-service at once
	POST: http://localhost:8080/actuator/bus-refresh
	GET: http://localhost:8082/limits	
	GET: http://localhost:8081/limits

	*/
}
