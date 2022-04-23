package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.Movie;
import com.alkemy.disneyAPI.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MovieService {

    @Autowired
    private MoviesRepository movieRepository;

    public ArrayList<Movie> getAllMovies() {
        return  (ArrayList<Movie>) movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
