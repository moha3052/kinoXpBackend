package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter @Setter
    private int movieID;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private String genre;
    @Getter @Setter
    private int duration;
    @Getter @Setter
    private int ageLimit;

    public Movie() {
    }


    public Movie(int movieID, String title, String genre, int duration, int ageLimit) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.ageLimit = ageLimit;
    }



}

