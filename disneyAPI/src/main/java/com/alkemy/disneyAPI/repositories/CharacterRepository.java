package com.alkemy.disneyAPI.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.alkemy.disneyAPI.classes.Character;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {


}
