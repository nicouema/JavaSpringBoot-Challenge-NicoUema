package com.alkemy.disneyAPI.repositories;

import com.alkemy.disneyAPI.classes.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<Movie, Integer>{

//  TODO: Solve error invalid column name movie_id
    @Query(value = "SELECT movie_id, title, image, creation_date from movies ORDER BY creation_date ASC", nativeQuery = true)
    List<Movie> getMoviesSortedAsc();

    @Query(value = "SELECT movie_id, title, image, creation_date FROM movies ORDER BY creation_date DESC", nativeQuery = true)
    List<Movie> getMoviesSortedDesc();
}
