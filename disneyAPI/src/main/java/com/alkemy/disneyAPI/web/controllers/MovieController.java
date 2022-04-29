package com.alkemy.disneyAPI.web.controllers;

import com.alkemy.disneyAPI.classes.Gender;
import com.alkemy.disneyAPI.classes.Movie;
import com.alkemy.disneyAPI.services.GenderService;
import com.alkemy.disneyAPI.services.MovieCharacterService;
import com.alkemy.disneyAPI.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    @Autowired
    MovieCharacterService movieCharacterService;
    @Autowired
    GenderService genderService;

//  Get Methods
    @GetMapping()
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping(value = "{id}")
    public Object getMovieById(@PathVariable Integer id){
        if (movieService.getMovieById(id) != null) {
            return movieService.getMovieById(id);
        }
        return "Movie not found!";
    }
    @GetMapping(params = "name")
    public Object getMovieByName(@RequestParam("name") String name) {
        return movieService.getMovieByName(name);
    }
    @GetMapping(params = "idGender")
    public List<Movie> getMoviesOfGender(@RequestParam("idGender") Integer idGender){
        Gender gender = (Gender) genderService.getGenderByID(idGender);
        if (gender!=null) {
            return gender.getMoviesOfGender();
        }
        return null;
    }
    @GetMapping(params = "order")
    public List<Movie> getMoviesSorted(@RequestParam("order") String order) {
        return movieService.getMoviesSorted(order);
    }

//  Post Methods
    @PostMapping()
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }
    @PostMapping(path = "/{idMovie}/character/{idCharacter}")
    public String addCharacterToMovie(@PathVariable Integer idCharacter, @PathVariable Integer idMovie) {
        return movieCharacterService.addCharacterToMovie(idCharacter, idMovie);
    }

//  Delete Methods
    @DeleteMapping(value = "{id}")
    public String delMovie(@PathVariable Integer id) {
        return movieService.delMovie(id);
    }
    @DeleteMapping(value = "/all")
    public void delAllMovies() {
        movieService.delAllMovies();
    }
    @DeleteMapping(path = "/{idMovie}/character/{idCharacter}")
    public String removeCharacterFromMovie( @PathVariable Integer idCharacter, @PathVariable Integer idMovie) {
        return movieCharacterService.removeCharacterFromMovie(idCharacter, idMovie);
    }

//    PUT METHODS
    @PutMapping(value = "{idMovie}")
    public Object updateMovie(@ModelAttribute Movie movie, @PathVariable Integer idMovie) {
        return movieService.updateMovie(movie, idMovie);
    }
}

