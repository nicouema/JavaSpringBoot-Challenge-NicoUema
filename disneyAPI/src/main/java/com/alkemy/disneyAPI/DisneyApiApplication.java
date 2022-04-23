package com.alkemy.disneyAPI;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.repositories.CharacterRepository;
import com.alkemy.disneyAPI.repositories.GenderRepository;
import com.alkemy.disneyAPI.repositories.MoviesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.alkemy.disneyAPI.*")
public class DisneyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisneyApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner createCommand(CharacterRepository characterRepository, MoviesRepository moviesRepository,
										   GenderRepository genderRepository) {
		return (args) -> {
			characterRepository.save(new Character("Image", "Buzz", "LightYear", 12, 1,
					"None"));
//			characterRepository.save(new Character("Image", "Woody", "",
//					12, 1, "None"));
//			characterRepository.save(new Character("Image", "Betty", "",
//					11, 1, "None"));
		};
	}

}
