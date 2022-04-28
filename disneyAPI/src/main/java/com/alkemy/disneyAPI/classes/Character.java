package com.alkemy.disneyAPI.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CharactersTable")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "character_id")
    private Integer character_id;

    private String image;
    private String name;
    private String lastname;
    private int age;
    private int weight;
    private String history;

    @JsonIgnoreProperties("characterIn")
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "characterIn", cascade = {CascadeType.MERGE,
                                                     CascadeType.REFRESH, CascadeType.DETACH})
    private List<Movie> moviesIn = new ArrayList<>();

//  Constructors
    protected Character() {
    }

    public Character(String name, String lastname, int age, int weight) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.weight = weight;
    }

    public Character(String image, String name, String lastname, int age, int weight, String history) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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
}
