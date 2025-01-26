package com.example.springBootbankingproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBankingProjectApplication {

	@Bean
	public ModelMapper mod_map()
	{
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBankingProjectApplication.class, args);
	}

}
