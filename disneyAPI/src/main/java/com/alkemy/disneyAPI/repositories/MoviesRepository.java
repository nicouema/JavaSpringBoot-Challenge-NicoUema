package com.alkemy.disneyAPI.repositories;

import com.alkemy.disneyAPI.classes.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface MoviesRepository extends CrudRepository<Movie, Integer>{


}
