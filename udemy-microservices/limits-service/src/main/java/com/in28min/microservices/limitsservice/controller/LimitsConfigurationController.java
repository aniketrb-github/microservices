package com.in28min.microservices.limitsservice.controller;

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

	@Autowired
	private Configuration configuration;
	
	@GetMapping
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMinimum(),  configuration.getMaximum());
	}
}
