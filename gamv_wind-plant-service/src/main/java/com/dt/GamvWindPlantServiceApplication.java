package com.dt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class})*/
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Plant-Service", version = "1.0",
                description = "This is the PLANT-SERVICE API is for internal use",
                contact = @Contact(name = "DigiTele Networks Pvt. Ltd.",
                                url = "http://www.digitelenetworks.com/",
                                email = "mailto:info@digitelenetworks.com")))
public class GamvWindPlantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamvWindPlantServiceApplication.class, args);
    }

}
