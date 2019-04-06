package org.arb_tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Entry point for Movie Catalog micro-service 
 * 
 * @author Aniket Bharsakale
 */
@SpringBootApplication
public class MovieCatalogServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApp.class, args);
	}

	/** 
	 * Singleton Beans which will be created by Spring Container at application initialization
	 * Hence, we can auto-wire these beans, ie request the spring container to inject them where we want
	*/
	@Bean
	public RestTemplate getRestTemplate () {
		return  new RestTemplate();
	}
	
	@Bean
	public WebClient.Builder getWebClientBuilder () {
		return WebClient.builder();
	}
}
