package com.apudasgupta.api.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@EnableCircuitBreaker
//@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@SpringBootApplication
public class MyMicroserviceApiGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMicroserviceApiGatewayZuulApplication.class, args);
	}

}
