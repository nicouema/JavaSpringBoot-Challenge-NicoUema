package com.alkemy.disneyAPI.web.controllers;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.services.CharacterService;
import com.alkemy.disneyAPI.services.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;
    @Autowired
    MovieCharacterService movieCharacterService;

    //  POST METHODS
    @PostMapping()
    public void saveCharacter(@RequestBody Character character) {
        characterService.saveCharacter(character);
    }

    //  GET METHODS
    @GetMapping()
    public List<Character> getAllCharacter() {
        return characterService.getAllCharacters();
    }
    @GetMapping(value = "{idCharacter}")
    public Object getCharacterById(@PathVariable Integer idCharacter) {
        if (characterService.getCharacterById(idCharacter) != null) {
            return characterService.getCharacterById(idCharacter);
        }
        return "Character not found!";
    }
    @GetMapping(params = "name")
    public Object getCharacterByName(@RequestParam("name") String name){
        return characterService.getCharacterByName(name);
    }
    @GetMapping(params = "age")
    public List<Character> getCharacterByAge(@RequestParam("age") int age){
        return characterService.getCharactersByAge(age);
    }
    @GetMapping(params = "weight")
    public List<Character> getCharactersByWeight(@RequestParam("weight") int weight) {
        return characterService.getCharactersByWeight(weight);
    }
//    TODO: getMoviesIn

    //  DELETE METHODS
    @DeleteMapping(path = "/{idCharacter}")
    public String delCharacter(@PathVariable Integer idCharacter) {
        movieCharacterService.removeCharacterFromAllMovies(idCharacter);
        return characterService.delCharacter(idCharacter);
    }
    @DeleteMapping(path = "/all")
    public void delAllCharacter(){
        movieCharacterService.removeAllCharactersFromMovies();
        characterService.delAllCharacter();
    }

//    PUT METHODS
    @PutMapping(value = "/{idCharacter}")
    public Object editCharacter(@RequestBody Character character, @PathVariable Integer idCharacter) {
        return characterService.updateCharacter(character, idCharacter);
    }

}
