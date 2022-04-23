package com.alkemy.disneyAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.alkemy.disneyAPI.repositories")
public class DisneyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisneyApiApplication.class, args);
	}

}
