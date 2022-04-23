package com.alkemy.disneyAPI.classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long character_id;
    private String image;
    private String name;
    private String lastname;
    private int age;
    private int weight;
    private String history;
    @ManyToMany(mappedBy = "characterIn")
    private List<Movie> moviesIn;

//  Constructors
    protected Character() {
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
}
