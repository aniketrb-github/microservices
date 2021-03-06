package com.in28min.microservices.limitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
/**
 * Entry point of the limits-service application
 *
 * @author Aniket Bharsakale
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class LimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
	}

}
