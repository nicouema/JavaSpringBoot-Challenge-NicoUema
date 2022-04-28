package com.alkemy.disneyAPI.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "movie_id")
    private Integer movie_id;

    private String image;
    private String title;
    private LocalDateTime creation_date;
    private int qualification;

    @JsonIgnoreProperties("moviesIn")
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinTable(name = "movie_character",
            joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "movie_id"),
            foreignKey = @ForeignKey(name = "fk_id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_character",
                    referencedColumnName = "character_id"),
            inverseForeignKey = @ForeignKey(name = "fk_id_movie"))
    private List<Character> characterIn = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "gender_id")
    private Gender gender_id;



//  Constructor

    public Movie() {
    }

    public Movie(String image, String tittle, int qualification) {
        this.image = image;
        this.title = tittle;
        this.creation_date = LocalDateTime.now();
        this.qualification = qualification;
    }

    public Movie(String tittle, int qualification) {
        this.title = tittle;
        this.qualification = qualification;
        this.creation_date = LocalDateTime.now();
    }

    public void addCharacterIn(Character character) {
        characterIn.add(character);
    }

    public void delCharacterIn(Character character) {
        characterIn.remove(character);
    }

    //  Getters and Setters


    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public List<Character> getCharacterIn() {
        return characterIn;
    }

    public void setCharacterIn(List<Character> characterIn) {
        this.characterIn = characterIn;
    }

    public Gender getGender_id() {
        return gender_id;
    }

    public void setGender_id(Gender gender_id) {
        this.gender_id = gender_id;
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
        return creation_date;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creation_date = creationDate;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }


//  toString
    @Override
    public String toString() {
        return "Movie{Id=" + movie_id +
                ", image=" + image +
                ", title='" + title + '\'' +
                ", creationDate=" + creation_date +
                ", qualification=" + qualification +
                ", characterIn=" + characterIn +
                '}';
    }

}
