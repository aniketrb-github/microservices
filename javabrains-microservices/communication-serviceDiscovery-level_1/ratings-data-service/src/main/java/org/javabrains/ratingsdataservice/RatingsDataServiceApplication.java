package org.javabrains.ratingsdataservice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class RatingsDataServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RatingsDataServiceApplication.class, args);
		SpringApplication application = new SpringApplication(RatingsDataServiceApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
