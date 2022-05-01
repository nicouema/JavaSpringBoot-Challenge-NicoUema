package com.alkemy.disneyAPI;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.classes.Gender;
import com.alkemy.disneyAPI.classes.Movie;
import com.alkemy.disneyAPI.services.CharacterService;
import com.alkemy.disneyAPI.services.GenderService;
import com.alkemy.disneyAPI.services.MovieService;
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
	public CommandLineRunner createCommand(CharacterService characterService, MovieService movieService,
										   GenderService genderService) {
		return (args) -> {
//			Character character01 = new Character("Image", "Buzz", "LightYear", 12, 1,
//					"None");
//			characterRepository.save(character01);
//			Character character02 = new Character("Image", "Woody", "",
//					12, 1, "None");
//			characterRepository.save(character02);
//			Character character03 = new Character("Image", "Betty", "",
//					11, 1, "None");
//			characterRepository.save(character03);
			Character character04 = new Character("Image", "Jack", "Sparrow",
					35, 70, "None");
			Character character05 = new Character("Image", "Elizabeth", "Swan",
					28, 58, "None");
////			System.out.println(characterRepository.findAll().toString());
//
			Gender gender01 = new Gender("Fantasy", "ImageGender");

			Movie movie01 = new Movie("Image01", "Piratas del Caribe"
					, 8);
			Movie movie02 = new Movie("Image02", "Piratas del Caribe 2"
					, 7);
			Movie movie03 = new Movie("Image04","Piratas del Caribe 3", 8);
//			genderService.createGender(gender01);
//			characterService.createCharacter(character04);
//			characterService.saveCharacter(character05);
//			movie01.setGender(gender01);
//			movie01.addCharacterIn(character04);
//			movie01.addCharacterIn(character05);
//			movie02.addCharacterIn(character04);
//			movie02.setGender(gender01);
//			movieService.createMovie(movie01);
//			movieService.saveMovie(movie02);
//			movieService.saveMovie(movie03);

		};
	}
}
