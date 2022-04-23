package com.alkemy.disneyAPI.controllers;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping()
    public List<Character> getAllCharacter() {
        return characterService.getAllCharacters();
//        String str = "";
//        for (Character character:characterService.getAllCharacters()) {
//            str += "\n" + character.toString();
//        }
//        System.out.print(str + "hola");
//        return str;
//        return "Hola Mundo";
    }
}
