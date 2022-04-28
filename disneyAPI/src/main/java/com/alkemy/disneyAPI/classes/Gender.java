package com.alkemy.disneyAPI.classes;

import javax.persistence.*;
import java.util.List;


@Table(name = "GendersTable")
@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false, name = "id_gender")
    private Integer id_gender;
    private String name;
    private String image;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "gender_id", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Movie> moviesOfGender;

    protected Gender() {
    }

    //    Constructor
    public Gender(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Gender(String name) {
        this.name = name;
    }

    public Integer getId_gender() {
        return id_gender;
    }

    public void setId_gender(Integer id_gender) {
        this.id_gender = id_gender;
    }

    public List<Movie> getMoviesOfGender() {
        return moviesOfGender;
    }

    public void setMoviesOfGender(List<Movie> moviesOfGender) {
        this.moviesOfGender = moviesOfGender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
