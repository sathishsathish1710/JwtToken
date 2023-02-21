package com.example.jwtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.jwtdemo"})

public class JwttokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwttokenApplication.class, args);
	}

}
