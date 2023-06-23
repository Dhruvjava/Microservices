package com.dt.gamv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.reactive.ReactiveManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication(exclude = ReactiveManagementWebSecurityAutoConfiguration.class)
@EnableAdminServer
@EnableDiscoveryClient
public class GamvWindAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamvWindAdminServerApplication.class, args);
	}

}
