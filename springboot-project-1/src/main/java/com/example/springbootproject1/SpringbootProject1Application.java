package com.example.springbootproject1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootProject1Application {

	@Bean
	public ModelMapper mod_map()
	{
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootProject1Application.class, args);
	}

}
