package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.classes.Gender;
import com.alkemy.disneyAPI.classes.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Services {
    @Autowired
    MovieService movieService;
    @Autowired
    CharacterService characterService;
    @Autowired
    GenderService genderService;

    /**
     *
     * @param characterId: Character who will be added to the movie.
     * @param movieId: Movie where the character will be added.
     * @return String: if it success, if not it will tell you why.
     */
    public String addCharacterToMovie(Integer characterId, Integer movieId) {
        if (movieService.movieExist(movieId)) {
            if (characterService.characterExist(characterId)){
                Character characterToAdd = characterService.getCharacterById(characterId);
                Movie movie = movieService.getMovieById(movieId);
                if (!movie.getCharactersIn().contains(characterToAdd)){
                    movie.addCharacterIn(characterToAdd);
                    movieService.createMovie(movie);
                    return "Character: " + characterToAdd.getName() + " " + characterToAdd.getLastname() +
                            " added to Movie: " + movie.getTitle();
                }
                else {
                    return "Character already in the movie!";
                }
            }
            else {
                return "Character with id: " + characterId + " doesn't exist!";
            }
        }
        else {
            return "Movie with id: " + movieId + " doesn't exist!";
        }
    }

    /**
     *
     * @param idCharacter: Character who will be removed from the movie.
     * @param idMovie: Movie where the character will be removed.
     * @return String: if it success, if not it will tell you why.
     */
    public String removeCharacterFromMovie(Integer idCharacter, Integer idMovie) {
        if (movieService.movieExist(idMovie)) {
            if (characterService.characterExist(idCharacter)) {
                Character characterToRemove = characterService.getCharacterById(idCharacter);
                Movie movie = movieService.getMovieById(idMovie);
                if (movie.getCharactersIn().contains(characterToRemove)) {
                    movie.delCharacterIn(characterToRemove);
                    movieService.createMovie(movie);
                    return "Character: " + characterToRemove.getName() + " " + characterToRemove.getLastname() +
                            " removed from Movie: " + movie.getTitle();
                } else {
                    return "Character not in the movie!";
                }
            } else {
                return "Character with id: " + idCharacter + " doesn't exist!";
            }
        } else {
            return "Movie with id: " + idMovie + " doesn't exist!";
        }
    }


    /**
     *
     * @param idCharacter: Character who will be removed from all the movies.
     */
    public void removeCharacterFromAllMovies(Integer idCharacter) {
        for(Movie movie: movieService.getAllMovies()){
            removeCharacterFromMovie(idCharacter, movie.getMovie_id());
        }
    }

    /**
     * It removed all the characters from all the movies.
     */
    public void removeAllCharactersFromMovies() {
        for(Character character: characterService.getAllCharacters())
            removeCharacterFromAllMovies(character.getCharacter_id());
    }

    public String setGenderToMovie(Integer idGender, Integer idMovie) {
        if (movieService.movieExist(idMovie)) {
            if (genderService.genderExist(idGender)){
                Gender genderToSet = genderService.getGenderByID(idGender);
                Movie movie = movieService.getMovieById(idMovie);
                if (movie.getGender() == null){
                    movie.setGender(genderToSet);
                    movieService.createMovie(movie);
                    return "Gender: " + genderToSet.getName() + " " +
                            " added to Movie: " + movie.getTitle();
                }
                else {
                    return "The movie already has a gender!";
                }
            }
            else {
                return "Gender with id: " + idGender + " doesn't exist!";
            }
        }
        else {
            return "Movie with id: " + idMovie + " doesn't exist!";
        }
    }

    public String removeGenderToMovie(Integer idGender, Integer idMovie) {
        if (movieService.movieExist(idMovie)) {
            if (genderService.genderExist(idGender)) {
                Gender genderToRemove = genderService.getGenderByID(idGender);
                Movie movie = movieService.getMovieById(idMovie);
                if (movie.getGender() == genderToRemove) {
                    movie.setGender(null);
                    movieService.createMovie(movie);
                    return "Character: " + genderToRemove.getName() + " " +
                            " removed from Movie: " + movie.getTitle();
                } else {
                    return "Not movie's gender!";
                }
            } else {
                return "Gender with id: " + idGender + " doesn't exist!";
            }
        } else {
            return "Movie with id: " + idMovie + " doesn't exist!";
        }
    }

    public List<Character> getCharactersByMovie(Integer movieId) {
        List<Character> listCharacters = new ArrayList<>();
        System.out.println("BEGIN");
        if (!movieService.movieExist(movieId)){
            System.out.println("NO EXIST");
            return null;
        }
        Movie movie = movieService.getMovieById(movieId);
        for(Character character:characterService.getAllCharacters()){
            System.out.println("<<<<Contains>>>>");
            if(character.getMoviesIn().contains(movie)){
                listCharacters.add(character);
            }
        }
        return listCharacters;
    }
    public List<Movie> getMoviesByGender(Integer idGender) {
        List<Movie> listMovie = new ArrayList<>();
        if (genderService.genderExist(idGender)) {
            Gender gender = genderService.getGenderByID(idGender);
            for (Movie movie: movieService.getAllMovies()) {
                if (movie.getGender() == gender) {
                    listMovie.add(movie);
                }
            }
            return listMovie;
        }
        return listMovie;
    }
}
