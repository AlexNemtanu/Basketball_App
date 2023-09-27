package com.gt.basketballapp;

import com.gt.basketballapp.mapper.CourtMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = CourtMapper.class)
public class BasketballAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketballAppApplication.class, args);
	}

}
