package com.micron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicronApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicronApplication.class, args);
	}

}
