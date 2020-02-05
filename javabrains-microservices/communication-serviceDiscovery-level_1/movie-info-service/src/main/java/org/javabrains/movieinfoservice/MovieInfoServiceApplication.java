package org.javabrains.movieinfoservice;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieInfoServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MovieInfoServiceApplication.class, args);
		SpringApplication application = new SpringApplication(MovieInfoServiceApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
	
	
	
	
	  @Bean public RestTemplate getRestTemplate() { return new RestTemplate(); }
	 
	
	/*
	 * @Bean public RestTemplate getRestTemplate() throws KeyStoreException,
	 * NoSuchAlgorithmException, KeyManagementException {
	 * 
	 * SSLContext sslContext = SSLContexts.custom() .loadTrustMaterial(null, new
	 * TrustSelfSignedStrategy()) .build();
	 * 
	 * SSLConnectionSocketFactory sslConnectionSocketFactory = new
	 * SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
	 * CloseableHttpClient httpClient = HttpClients.custom()
	 * .setSSLSocketFactory(sslConnectionSocketFactory) .build();
	 * 
	 * HttpComponentsClientHttpRequestFactory requestFactory = new
	 * HttpComponentsClientHttpRequestFactory();
	 * 
	 * requestFactory.setHttpClient(httpClient);
	 * 
	 * return new RestTemplate(requestFactory); }
	 */

}
