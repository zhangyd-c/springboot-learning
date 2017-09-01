package com.zyd.cloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootCloudEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCloudEurekaClientApplication.class, args);
	}
}
