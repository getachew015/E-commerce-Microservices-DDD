package com.meru.productscatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.meru.productscatalogservice")
@EnableDiscoveryClient
public class ProductsCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsCatalogServiceApplication.class, args);
	}

}
