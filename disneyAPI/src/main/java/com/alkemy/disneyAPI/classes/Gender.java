package com.alkemy.disneyAPI.classes;

import javax.persistence.*;
import java.util.List;


@Table(name = "Gender")
@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    private Long gender_id;
    private String name;
    private String image;
    @OneToMany(mappedBy = "gender")
    private List<Movie> moviesOfGender;

    protected Gender() {
    }

    //    Contructor
    public Gender(String name, String image) {
        this.name = name;
        this.image = image;
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
