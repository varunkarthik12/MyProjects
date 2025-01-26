package com.example.demoApp_Design;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAppDesignApplication {

	@Bean
	public ModelMapper mod_map()
	{
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoAppDesignApplication.class, args);
	}

}
