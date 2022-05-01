package com.alkemy.disneyAPI.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Characters")
@JsonPropertyOrder({"character_id", "name", "lastname", "age", "weight", "history", "image", "moviesIn"})
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "character_id")
    private Integer character_id;

    private String image;
    private String name;
    private String lastname;
    private Integer age;
    private Integer weight;
    private String history;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "charactersIn", cascade = {CascadeType.MERGE,
                                                     CascadeType.REFRESH, CascadeType.DETACH})
    @JsonIgnoreProperties("charactersIn")
    private List<Movie> moviesIn = new ArrayList<>();

//  Constructors
    protected Character() {
    }

    public Character(String name, String lastname, Integer age, Integer weight) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.weight = weight;
    }

    public Character(String image, String name, String lastname, Integer age, Integer weight, String history) {
        this.image = image;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.weight = weight;
        this.history = history;
    }

//  toString Method
    @Override
    public String toString() {
        return "Character{" +
                "id=" + character_id +
                ", image=" + image +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", history='" + history + '\'' +
                '}';
    }

//  Getters and Setter

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Integer getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(Integer character_id) {
        this.character_id = character_id;
    }

    public List<Movie> getMoviesIn() {
        return moviesIn;
    }

    public void setMoviesIn(List<Movie> moviesIn) {
        this.moviesIn = moviesIn;
    }

    public void clearMoviesIn() {
        this.moviesIn.clear();
    }

    public Character update(Character character) {
        if (character.getName() != null) {
            this.setName(character.getName());
        }
        if (character.getLastname() != null) {
            this.setLastname(character.getLastname());
        }
        if (character.getAge() != null) {
            this.setAge(character.getAge());
        }
        if (character.getWeight() != null) {
            this.setWeight(character.getWeight());
        }
        if (character.getHistory() != null) {
            this.setHistory(character.getHistory());
        }
        if (character.getImage() != null) {
            this.setImage(character.getImage());
        }
        return this;
    }
}
