package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class UrbaneyeAiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbaneyeAiBackendApplication.class, args);
	}

}
