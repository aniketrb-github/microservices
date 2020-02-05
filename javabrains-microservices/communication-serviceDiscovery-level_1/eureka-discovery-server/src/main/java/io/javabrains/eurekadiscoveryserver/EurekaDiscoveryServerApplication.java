package io.javabrains.eurekadiscoveryserver;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryServerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EurekaDiscoveryServerApplication.class, args);
		SpringApplication application = new SpringApplication(EurekaDiscoveryServerApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
