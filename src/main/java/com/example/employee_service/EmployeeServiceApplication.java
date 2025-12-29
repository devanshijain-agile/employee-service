package com.example.employee_service;

import com.example.employee_service.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner testMongo(EmployeeRepository repository) {
		return args -> {
			System.out.println("MongoDB connected successfully");
			System.out.println("Employee count: " + repository.count());
		};
	}


}
