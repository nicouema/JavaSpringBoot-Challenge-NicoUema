package com.alkemy.disneyAPI.classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name= "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private String image;
    private String title;
    private Date creationDate;
    private int qualification;
    private ArrayList<Character> characterIn;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public ArrayList<Character> getCharacterIn() {
        return characterIn;
    }

    public void setCharacterIn(ArrayList<Character> characterIn) {
        this.characterIn = characterIn;
    }

    @Override
    public String toString() {
        return "Movie{" + id +
                "image=" + image +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", qualification=" + qualification +
                ", characterIn=" + characterIn +
                '}';
    }
}
