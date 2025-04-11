package com.smartparking.backend.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SmartparkingbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartparkingbackendApplication.class, args);
    }

}
