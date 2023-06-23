package com.dt.gamv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GamvWindEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamvWindEurekaServerApplication.class, args);
    }

}
