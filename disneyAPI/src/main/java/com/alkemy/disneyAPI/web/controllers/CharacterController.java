package com.alkemy.disneyAPI.web.controllers;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.services.CharacterService;
import com.alkemy.disneyAPI.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;
    @Autowired
    Services services;

    //  POST METHODS
    @PostMapping()
    public Character createCharacter(@RequestBody Character character) {
        return characterService.createCharacter(character);
    }

    //  GET METHODS
    @GetMapping(value = "{idCharacter}")
    public Object getCharacterById(@PathVariable Integer idCharacter) {
        if (characterService.getCharacterById(idCharacter) != null) {
            return characterService.getCharacterById(idCharacter);
        }
        return "Character not found!";
    }
    @GetMapping()
    public List<Character> searchAndFilterCharacter(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "age", required = false) Integer age,
                                                    @RequestParam(value = "weight", required = false) Integer weight,
                                                    @RequestParam(value = "idMovie", required = false) Integer idMovie) {
        List<Character> characterList = characterService.getAllCharacters();
        if (name != null){
            characterList.retainAll(characterService.getCharactersByName(name));
        }
        if (age != null) {
            characterList.retainAll(characterService.getCharactersByAge(age));
        }
        if (weight != null) {
            characterList.retainAll(characterService.getCharactersByWeight(weight));
        }
        if (idMovie != null) {
            characterList.retainAll(services.getCharactersByMovie(idMovie));
        }
        return characterList;
    }
//    @GetMapping(params = "name")
//    public Object getCharacterByName(@RequestParam("name") String name){
//        return characterService.getCharacterByName(name);
//    }
//    @GetMapping(params = "age")
//    public List<Character> getCharacterByAge(@RequestParam("age") int age){
//        return characterService.getCharactersByAge(age);
//    }
//    @GetMapping(params = "weight")
//    public List<Character> getCharactersByWeight(@RequestParam("weight") int weight) {
//        return characterService.getCharactersByWeight(weight);
//    }
//    TODO: getMoviesIn

    //  DELETE METHODS
    @DeleteMapping(value = "/{idCharacter}")
    public String delCharacter(@PathVariable Integer idCharacter) {
        services.removeCharacterFromAllMovies(idCharacter);
        return characterService.delCharacter(idCharacter);
    }
    @DeleteMapping(value = "all")
    public void delAllCharacter(){
        services.removeAllCharactersFromMovies();
        characterService.delAllCharacter();
    }

//    PUT METHODS
    @PutMapping(value = "{idCharacter}")
    public Object updateCharacter(@RequestBody Character character, @PathVariable Integer idCharacter) {
        return characterService.updateCharacter(character, idCharacter);
    }

}
