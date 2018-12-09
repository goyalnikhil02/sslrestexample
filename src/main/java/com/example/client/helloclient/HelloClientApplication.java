package com.example.client.helloclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@EnableCircuitBreaker
@SpringBootApplication
//@EnableSwagger2
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableAspectJAutoProxy
public class HelloClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloClientApplication.class, args);
	}

	
}
