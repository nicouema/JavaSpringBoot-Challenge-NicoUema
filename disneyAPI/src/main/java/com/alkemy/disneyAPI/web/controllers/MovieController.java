package com.alkemy.disneyAPI.web.controllers;

import com.alkemy.disneyAPI.classes.Movie;
import com.alkemy.disneyAPI.services.MovieService;
import com.alkemy.disneyAPI.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    @Autowired
    Services services;

//  Get Methods
    @GetMapping()
    public List<Movie> searchAndFilterMovies(@RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "idGender", required = false) Integer idGender,
                                         @RequestParam(value = "order", required = false) String order){
    List<Movie> listMovies = movieService.getAllMovies();
    if (order != null) {
        listMovies = movieService.getMoviesSorted(order);
    }
    if (name != null) {
        listMovies.retainAll(movieService.getMoviesByTitle(name));
    }
    if (idGender != null) {
        listMovies.retainAll(services.getMoviesByGender(idGender));
    }
    return listMovies;
}
    @GetMapping(value = "{id}")
    public Object getMovieById(@PathVariable Integer id){
        if (movieService.getMovieById(id) != null) {
            return movieService.getMovieById(id);
        }
        return "Movie not found!";
    }

//  Post Methods
    @PostMapping()
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }
    @PostMapping(path = "/{idMovie}/character/{idCharacter}")
    public String addCharacterToMovie(@PathVariable Integer idCharacter, @PathVariable Integer idMovie) {
        return services.addCharacterToMovie(idCharacter, idMovie);
    }
    @PostMapping(path = "/{idMovie}/gender/{idGender}")
    public String setGenderToMovie(@PathVariable Integer idGender, @PathVariable Integer idMovie) {
        return services.setGenderToMovie(idGender, idMovie);
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
        return services.removeCharacterFromMovie(idCharacter, idMovie);
    }
    @DeleteMapping(path = "/{idMovie}/gender/{idGender}")
    public String removeGenderToMovie(@PathVariable Integer idGender, @PathVariable Integer idMovie) {
        return services.removeGenderToMovie(idGender, idMovie);
    }

//    PUT METHODS
    @PutMapping(value = "{idMovie}")
    public Object updateMovie(@RequestBody Movie movie, @PathVariable Integer idMovie) {
        return movieService.updateMovie(movie, idMovie);
    }
}

