package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.repositories.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CharacterService {

    @Autowired
    CharactersRepository characterRepository;

    /**
     *
     * @param characterId: Movie's id searched.
     * @return true if it's exist, otherwise false.
     */
    public boolean characterExist(Integer characterId){
        return characterRepository.existsById(characterId);
    }

    // Delete Methods
    public String delCharacter(Integer characterId) {
        if (characterExist(characterId)){
            characterRepository.deleteById(characterId);
            return "Character with characterId: " + characterId + " removed!";
        }
        else {
            return "Character not found!";
        }
    }
    public void delAllCharacter() {
        characterRepository.deleteAll();
    }

    // Post Methods
    public void saveCharacter(Character character){
        characterRepository.save(character);
    }

    // GetMethods
    public List<Character> getAllCharacters() {
        return (List<Character>) characterRepository.findAll();
    }
    public Object getCharacterById(Integer id) {
        if (characterExist(id)) {
            return characterRepository.findById(id).get();
        }
        else {
            return "Character not found!";
        }
    }
    public Character getCharacterByName(String name) {
        for(Character character:getAllCharacters()) {
            if(Objects.equals(character.getName(), name)){
                return character;
            }
        }
        return null;
    }
    public List<Character> getCharactersByAge(int age) {
        List<Character> listCharacters = new ArrayList<>();
        for(Character character:getAllCharacters()){
            if(Objects.equals(character.getAge(), age)){
                listCharacters.add(character);
            }
        }
        return listCharacters;
    }
    public List<Character> getCharactersByWeight(int weight) {
        List<Character> listCharacters = new ArrayList<>();
        for(Character character:getAllCharacters()){
            if(Objects.equals(character.getWeight(), weight)){
                listCharacters.add(character);
            }
        }
        return listCharacters;
    }
    public void getCharacterMoviesIn(Integer id) {
    }
}
