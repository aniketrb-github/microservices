package org.javabrains.moviecatalogservice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient		// Registers itself as a client in eureka server's service registry
@EnableCircuitBreaker	// Hystrix Circuit Breaker
@EnableHystrixDashboard	// Hystrix Dashboard provision
public class MovieCatalogServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MovieCatalogServiceApplication.class, args);
		SpringApplication application = new SpringApplication(MovieCatalogServiceApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
