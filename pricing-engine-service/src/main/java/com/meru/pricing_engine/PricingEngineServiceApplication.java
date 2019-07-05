package com.meru.pricing_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PricingEngineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricingEngineServiceApplication.class, args);
	}

}
