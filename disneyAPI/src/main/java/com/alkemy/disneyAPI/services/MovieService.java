package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.classes.Movie;
import com.alkemy.disneyAPI.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class MovieService {

    @Autowired
    private MoviesRepository movieRepository;
    @Autowired
    private GenderService genderService;

    /**
     *
     * @param movieId: Movie's id searched.
     * @return true if it's exist, otherwise false.
     */
    public boolean movieExist(Integer movieId){
        return movieRepository.existsById(movieId);
    }

//  Get Methods
    public List<Movie> getAllMovies() {
        return  (List<Movie>) movieRepository.findAll();
    }
    public Movie getMovieById(Integer id) {
        if (movieExist(id)){
            return movieRepository.findById(id).get();
        }
        else {
            return null;
        }
    }
    public Movie getMovieByName(String name) {
        for (Movie movie:getAllMovies()) {
            if (Objects.equals(movie.getTitle(), name)) {
                System.out.println("<<<<<FOUND>>>>>");
                return movie;
            }
        }
        return null;
    }

//  Post Methods
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);}

//  Delete Methods
    public String delMovie(Integer id) {
        if (movieExist(id)){
            movieRepository.deleteById(id);
            return "Movie with id: " + id + " removed!";
        }
        else {
            return "Movie not found!";
        }
    }
    public void removeCharacterFromAllMovies(Integer id){
        List<Movie> listMovies = getAllMovies();
        for (Movie movie:listMovies){
            List<Character> characterList = movie.getCharacterIn();
            for(Character character:characterList){
                if (Objects.equals(character.getCharacter_id(), id)){
                    characterList.remove(character);
                }
            }
            movie.setCharacterIn(characterList);
        }
    }
    public void delAllMovies(){
        movieRepository.deleteAll();
    }

    public List<Movie> getMoviesSorted(String order) {
    if (Objects.equals(order, "ASC")) {
        return (List<Movie>) movieRepository.getMoviesSortedAsc();
    }
    else{
        return movieRepository.getMoviesSortedDesc();
    }
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

//    PUT METHOD
    public Object updateMovie(Movie movie, Integer idMovie) {
        Movie movieToEdit = getMovieById(idMovie);
        if (movieToEdit != null) {
            movieToEdit.setTitle(movie.getTitle());
            movieToEdit.setImage(movie.getImage());
            movieToEdit.setQualification(movie.getQualification());
            movieToEdit.setGender_id(movie.getGender_id());
            return movieToEdit;
        }
        return "Movie not Found!";
    }
}
