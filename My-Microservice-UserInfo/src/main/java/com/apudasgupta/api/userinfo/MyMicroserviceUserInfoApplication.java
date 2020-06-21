package com.apudasgupta.api.userinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyMicroserviceUserInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMicroserviceUserInfoApplication.class, args);
	}

}
