package com.alkemy.disneyAPI.classes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Movies")
@JsonPropertyOrder({"movie_id", "title", "image", "qualification", "gender", "creationDate", "charactersIn"})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "movie_id")
    private Integer movie_id;

    private String image;
    private String title;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate = LocalDateTime.now();
    private Integer qualification;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinTable(name = "movie_character",
            joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "movie_id"),
            foreignKey = @ForeignKey(name = "fk_id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_character",
                    referencedColumnName = "character_id"),
            inverseForeignKey = @ForeignKey(name = "fk_id_movie"))
    @JsonIgnoreProperties({"moviesIn"})
    private List<Character> charactersIn = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "gender")
    @JsonIgnoreProperties("moviesOfGender")
    private Gender gender;

//  Constructor

    public Movie() {
    }

    public Movie(String image, String tittle, Integer qualification) {
        this.image = image;
        this.title = tittle;
        this.creationDate = LocalDateTime.now();
        this.qualification = qualification;
    }

    public Movie(String tittle, Integer qualification) {
        this.title = tittle;
        this.qualification = qualification;
        this.creationDate = LocalDateTime.now();
    }

    public void addCharacterIn(Character character) {
        charactersIn.add(character);
    }

    public void delCharacterIn(Character character) {
        charactersIn.remove(character);
    }

    //  Getters and Setters
    @JsonIgnore
    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public List<Character> getCharactersIn() {
        return charactersIn;
    }

    public void setCharactersIn(List<Character> charactersIn) {
        this.charactersIn = charactersIn;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }


//  toString
    @Override
    public String toString() {
        return "Movie{Id=" + movie_id +
                ", image=" + image +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", qualification=" + qualification +
                ", charactersIn=" + charactersIn +
                '}';
    }

    public Movie update(Movie movie) {
        if (movie.getTitle() != null) {
            this.setTitle(movie.getTitle());
        }
        if (movie.getQualification() != null) {
            this.setQualification(movie.getQualification());
        }
        if (movie.getImage() != null) {
            this.setImage(movie.getImage());
        }
        return this;
    }
}
