package com.alkemy.disneyAPI.web.controllers;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.services.CharacterService;
import com.alkemy.disneyAPI.services.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/characters", method = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET})
public class CharacterController {

    @Autowired
    CharacterService characterService;
    @Autowired
    MovieCharacterService movieCharacterService;


    //  Get methods
    @GetMapping()
    public List<Character> getAllCharacter() {
        return characterService.getAllCharacters();
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

//  Delete Methods
    @DeleteMapping(path = "/del={characterId}")
    public String delCharacter(@PathVariable Integer characterId) {
        movieCharacterService.removeCharacterFromAllMovies(characterId);
        return characterService.delCharacter(characterId);
    }
    @DeleteMapping(path = "/del=all")
    public void delAllCharacter(){
        movieCharacterService.removeAllCharactersFromMovies();
        characterService.delAllCharacter();
    }

//  Post Methods
    @PostMapping("/save/{name}/{lastName}/{age}/{weight}")
    public void saveCharacter(@PathVariable String name, @PathVariable String lastName,
                              @PathVariable int age, @PathVariable int weight) {
        Character character = new Character(name, lastName, age, weight);
        characterService.saveCharacter(character);
    }
}
