package com.alkemy.disneyAPI.repositories;

import com.alkemy.disneyAPI.classes.Gender;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GendersRepository extends CrudRepository<Gender, Integer> {

}
