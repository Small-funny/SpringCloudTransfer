package com.jhy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.jhy.springcloud"})
//@ComponentScan("com.jhy.springcloud")
public class FeignConsumer {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumer.class);
    }
}
