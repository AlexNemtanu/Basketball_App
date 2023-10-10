package com.gt.basketballapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gt.basketballapp")
public class BasketballAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketballAppApplication.class, args);
	}
}
