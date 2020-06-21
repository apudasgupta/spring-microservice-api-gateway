# spring-microservice-api-gateway
Spring Microservice API Gateway using Eureka, Zuul and Hystrix

#spring #microservice #gatewayapi #eureka #zuul #hystrix #swagger #loadbalance

There are 5 Spring Boot Projects:-

Project 1
	My-Microservice-Discovery-Server
		Eureka running on default port 8761 
		Eureka server for service registration and discovery
		http://localhost:8761/

Project 2
	My-Microservice-Api-Gateway-Zuul
		runs on port 8090 
		Zuul has been used to make api gateway. Provides entry points to the clients for all services.
		Load Balancing with Zuul and Eureka : 
			If multiple instance of backend service is run on different ports, it will be loadbalanced
		zuul is configured to process requests starting with /api
		
		Following rest points are available on API Gateway  :

		http://localhost:8090/api/userInfoService/userInfo/getAll
		http://localhost:8090/api/userInfoService/userInfo/getById?userId=1
		http://localhost:8090/api/userContactService/contactInfo/getAll
		http://localhost:8090/api/userContactService/contactInfo/getById?userId=1
		http://localhost:8090/api/userDetailsService/userDetails/getAll
		http://localhost:8090/api/userDetailsService/userDetails/getById?userId=1
		
		
		If any of the backend service ie. USER-INFO-SERVICE,USER-CONTACT-SERVICE,USER-DETAILS-SERVICE is down,
		we will get fallback response "service is not available".

	
Project 3
	My-Microservice-UserInfo
		runs on port 8095 
		registered as USER-INFO-SERVICE in the Eureka server
		fetch only id, name and email of user
		provides 2 rest points , considering them as backend service we will not accesse them directly .
		will be accessed through gateway api.
			http://localhost:8095/userInfo/getAll
			http://localhost:8095/userInfo/getById?userId=1
		
		
Project 4
	My-Microservice-UserContact
		runs on port 8096
		registered as USER-CONTACT-SERVICE in the Eureka server
		fetch only id, phone and address of user
		provides 2 rest points , considering them as backend service we will not accesse them directly .
		will be accessed through gateway api.
			http://localhost:8096/contactInfo/getAll
			http://localhost:8096/contactInfo/getById?userId=1
		
Project 5
	My-Microservice-UserDetails
		runs on port 8097
		registered as USER-DETAILS-SERVICE in the Eureka server
		fetch all information of user : id, name, email, phone and address 
		It fetch  id, name and email from USER-INFO-SERVICE
		and fetch id, phone and address of user from USER-CONTACT-SERVICE
		It uses Eureka for service discovery to fetch records.
		provides 2 rest points , considering them as backend service we will not accesse them directly .
		will be accessed through gateway api.
			http://localhost:8097/userDetails/getAll
			http://localhost:8097/userDetails/getById?userId=1
		
			
If you run all project we can see the service registered in Eureka http://localhost:8761/	
	USER-CONTACT-SERVICE
	USER-DETAILS-SERVICE
	USER-INFO-SERVICE	
	ZUUL-API-GATEWAY-SERVICE

