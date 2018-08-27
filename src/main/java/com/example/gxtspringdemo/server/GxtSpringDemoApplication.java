package com.example.gxtspringdemo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.gxtspringdemo.shared.model")
public class GxtSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GxtSpringDemoApplication.class, args);
	}
}
