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
@RequestMapping(method = {RequestMethod.POST, RequestMethod.DELETE,
                                           RequestMethod.GET, RequestMethod.PATCH})
public class MovieController {

    @Autowired
    MovieService movieService;
    @Autowired
    MovieCharacterService movieCharacterService;
    @Autowired
    GenderService genderService;

//  Get Methods
    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/movies/{id}")
    public Object getMovieById(@PathVariable Integer id){
        return movieService.getMovieById(id);
    }
    @GetMapping(path = "/movies", params = "name")
    public Object getMovieByName(@RequestParam("name") String name) {
        return movieService.getMovieByName(name);
    }
    @GetMapping(path = "/movies",params = "idGender")
    public List<Movie> getMoviesOfGender(@RequestParam("idGender") Integer idGender){
        Gender gender = (Gender) genderService.getGenderByID(idGender);
        if (gender!=null) {
            return gender.getMoviesOfGender();
        }
        return null;
    }
    @GetMapping(path = "/movies", params = "order")
    public List<Movie> getMoviesSorted(@RequestParam("order") String order) {
        return movieService.getMoviesSorted(order);
    }

//  Post Methods
    @PostMapping("/movies/save/{tittle}/{qualification}")
    public void saveMovie(@PathVariable String tittle, @PathVariable int qualification) {
        this.movieService.saveMovie(new Movie(tittle, qualification));
    }
    @PostMapping("/movies/{id}/{tittle}")
    public void changeTittle(@PathVariable Integer id, @PathVariable String tittle){
        Movie movie = (Movie) movieService.getMovieById(id);
        movie.setTitle(tittle);
        movieService.saveMovie(movie);
    }
    @PostMapping(path = "/POST/movies/{idMovie}/character/{idCharacter}")
    public String addCharacterToMovie(@PathVariable Integer idCharacter, @PathVariable Integer idMovie) {
        return movieCharacterService.addCharacterToMovie(idCharacter, idMovie);
    }

//  Delete Methods
    @DeleteMapping("/movies/del={id}")
    public String delMovie(@PathVariable Integer id) {
        return movieService.delMovie(id);
    }
    @DeleteMapping("/movies/del=all")
    public void delAllMovies() {
        movieService.delAllMovies();
    }
    @DeleteMapping("/DELETE/movies/{idMovie}/character/{idCharacter}")
    public String removeCharacterFromMovie( @PathVariable Integer idCharacter, @PathVariable Integer idMovie) {
        return movieCharacterService.removeCharacterFromMovie(idCharacter, idMovie);
    }
}

