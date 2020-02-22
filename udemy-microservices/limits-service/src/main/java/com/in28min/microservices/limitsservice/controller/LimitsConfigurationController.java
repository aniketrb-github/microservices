package com.in28min.microservices.limitsservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28min.microservices.limitsservice.bean.LimitConfiguration;
import com.in28min.microservices.limitsservice.config.Configuration;

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
}
