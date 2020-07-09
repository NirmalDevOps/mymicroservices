package com.nirubiru.moviecatalogservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogServiceApplication {

//	private DiscoveryClient discoveryClient;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplateBean() {
		return new RestTemplate();
	}

	/*
	 * @Bean public WebClient.Builder getWebClientBuilder() { return
	 * WebClient.builder(); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
		System.out.println("Hello Movie Catalog Service running on port 8081");

		//
	}

}