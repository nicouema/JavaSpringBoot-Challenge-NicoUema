package com.alkemy.disneyAPI.controllers;

import com.alkemy.disneyAPI.classes.Movie;
import com.alkemy.disneyAPI.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping()
    public ArrayList<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie) {
        return this.movieService.saveMovie(movie);
    }
}

