package com.micron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicronApplication {

	public static Logger logger = LoggerFactory.getLogger(MicronApplication.class);

	public static void main(String[] args) {
		logger.info("Micron application started...");
		SpringApplication.run(MicronApplication.class, args);
	}

}
