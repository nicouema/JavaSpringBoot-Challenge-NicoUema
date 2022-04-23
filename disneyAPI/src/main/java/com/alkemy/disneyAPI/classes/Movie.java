package com.alkemy.disneyAPI.classes;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long movie_id;
    private String image;
    private String title;
    private Date creationDate;
    private int qualification;

    @ManyToMany(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id",
            referencedColumnName = "character_id"))
    private List<Character> characterIn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id")
    private Gender gender;

//  Constructor

    protected Movie() {
    }

    public Movie(String image, String title, Date creationDate, int qualification, List<Character> characterIn, Gender gender) {
        this.image = image;
        this.title = title;
        this.creationDate = creationDate;
        this.qualification = qualification;
        this.characterIn = characterIn;
        this.gender = gender;
    }

    //  Getters and Setters
    public List<Character> getCharacterIn() {
        return characterIn;
    }

    public void setCharacterIn(List<Character> characterIn) {
        this.characterIn = characterIn;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

//  toString
    @Override
    public String toString() {
        return "Movie{" + movie_id +
                "image=" + image +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", qualification=" + qualification +
                ", characterIn=" + characterIn +
                '}';
    }
}
