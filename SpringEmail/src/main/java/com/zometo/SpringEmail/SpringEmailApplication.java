package com.zometo.SpringEmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailApplication.class, args);
	}

}
