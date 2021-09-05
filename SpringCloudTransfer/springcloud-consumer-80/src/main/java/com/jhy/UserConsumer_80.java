package com.jhy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumer_80.class);
    }
}
