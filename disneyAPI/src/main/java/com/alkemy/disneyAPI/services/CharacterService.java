package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.disneyAPI.classes.Character;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public List<Character> getAllCharacters() {
        return (List<Character>) characterRepository.findAll();
    }
}
