package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.classes.Movie;
import com.alkemy.disneyAPI.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Movie> getMovieByName(String name) {
        List<Movie> listMovies = new ArrayList<>();
        for (Movie movie:getAllMovies()) {
            String movieName = movie.getTitle().toLowerCase();
            if (movieName.contains(name.toLowerCase())) {
                listMovies.add(movie);
            }
        }
        return listMovies;
    }

//  Post Methods
    public Movie createMovie(Movie movie) {
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
            List<Character> characterList = movie.getCharactersIn();
            for(Character character:characterList){
                if (Objects.equals(character.getCharacter_id(), id)){
                    characterList.remove(character);
                }
            }
            movie.setCharactersIn(characterList);
        }
    }
    public void delAllMovies(){
        movieRepository.deleteAll();
    }

    public List<Movie> getMoviesSorted(String order) {
        return switch (order) {
            case "ASC" -> movieRepository.getMoviesSortedAsc();
            case "DESC" -> movieRepository.getMoviesSortedDesc();
            default -> getAllMovies();
        };
    }

//    PUT METHOD
    public Object updateMovie(Movie movie, Integer idMovie) {
        Movie movieToEdit = getMovieById(idMovie);
        if (movieToEdit != null) {
            movieToEdit = movieToEdit.update(movie);
//            if (movie.getGender_id() != null && genderService.getGenderByID(movie.getGender_id()) != null)
            movieRepository.save(movieToEdit);
            return movieToEdit;
        }
        return "Movie not Found!";
    }

    public List<Movie> getMoviesByTitle(String name) {
        List<Movie> listMovie = new ArrayList<>();
        for (Movie movie:getAllMovies()){
            String title = movie.getTitle().toLowerCase();
            if (title.contains(name.toLowerCase())){
                listMovie.add(movie);
            }
        }
        return listMovie;
    }

}
