package com.alkemy.disneyAPI.services;

import com.alkemy.disneyAPI.classes.Character;
import com.alkemy.disneyAPI.classes.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieCharacterService {
    @Autowired
    MovieService movieService;
    @Autowired
    CharacterService characterService;

    /**
     *
     * @param characterId: Character who will be added to the movie.
     * @param movieId: Movie where the character will be added.
     * @return String: if it success, if not it will tell you why.
     */
    public String addCharacterToMovie(Integer characterId, Integer movieId) {
        if (movieService.movieExist(movieId)) {
            if (characterService.characterExist(characterId)){
                Character characterToAdd = (Character) characterService.getCharacterById(characterId);
                Movie movie = (Movie) movieService.getMovieById(movieId);
                if (!movie.getCharacterIn().contains(characterToAdd)){
                    movie.addCharacterIn(characterToAdd);
                    movieService.saveMovie(movie);
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
                Character characterToRemove = (Character) characterService.getCharacterById(idCharacter);
                Movie movie = (Movie) movieService.getMovieById(idMovie);
                movie.delCharacterIn(characterToRemove);
                movieService.saveMovie(movie);
                return "Character: " + characterToRemove.getName() + " " + characterToRemove.getLastname() +
                        " removed from Movie: " + movie.getTitle();
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
}
