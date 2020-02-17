package com.in28min.microservices.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Entry point for this Spring Cloud Config Server
 *
 * @author Aniket Bharsakale
 */

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
	
	/**
	 * API's to retrieve the Configuration data from Git repository for following environments
	 * ----------------------------------------------------------------------------------------------------------
	 * ENVIRONMENT	|	SPRING-CONFIG-SERVICE-FILENAME		|	API												|
	 * ----------------------------------------------------------------------------------------------------------
	 * default		|	limits-service.properties			|	http://localhost:8888/limits-service/default 	|
	 * QA			|	limits-service-qa.properties		|	http://localhost:8888/limits-service/qa			|
	 * DEV			|	limits-service-dev					|	http://localhost:8888/limits-service/dev		|
	 * ----------------------------------------------------------------------------------------------------------
	 */

}
