package com.dt.gamv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GamvWindGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamvWindGatewayApplication.class, args);
    }

}
