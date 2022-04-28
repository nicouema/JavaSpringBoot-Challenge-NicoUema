package com.alkemy.disneyAPI.repositories;

import com.alkemy.disneyAPI.classes.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersRepository extends CrudRepository<Character, Integer> {


}
