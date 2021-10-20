package com.mindtree.FlightApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FlightAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightAppApplication.class, args);
	}

}
