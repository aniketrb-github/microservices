package com.in28mins.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/**
 * Netflix Zuul API Gateway server
 * @author Aniket Bharsakale 
 */
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableZuulProxy	// To make itself the ZUUL API Gateway Server
@EnableEurekaClient	// To register itself with Eureka Server Registry
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	/**
	 * Spring cloud sleuth tracing for API requests accross multiple modules 
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
