package com.virtusa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaNounApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNounApplication.class, args);
	}
}
