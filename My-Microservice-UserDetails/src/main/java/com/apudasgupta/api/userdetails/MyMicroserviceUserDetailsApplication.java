package com.apudasgupta.api.userdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MyMicroserviceUserDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMicroserviceUserDetailsApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
//	@Bean
//    public Docket myDocketConfig() { 
//        return new Docket(DocumentationType.SWAGGER_2)  
//          .select()      
////          .paths(PathSelectors.ant("/api/**"))
//          .apis(RequestHandlerSelectors.basePackage("com.apudasgupta.discovery.controller"))              
//          .paths(PathSelectors.any())                          
//          .build()
//          .apiInfo(apiInfo());                                           
//    }
//	private ApiInfo apiInfo() {
//	    return new ApiInfo(
//	      "User Details Service REST API Documentation ", 
//	      "Sample API for testing Spring Boot Microservices using Eureka for Service Discovery .", 
//	      "1.0", 
//	      "Terms of service", 
//	      new Contact("Apu Das Gupta", "www.apudasgupta.com", "great.adgupta@gmail.com"), 
//	      "License of API", "API license URL", Collections.emptyList());
//	}

}
