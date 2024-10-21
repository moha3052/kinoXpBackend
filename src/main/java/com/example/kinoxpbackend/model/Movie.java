package com.example.kinoxpbackend.model;

import com.example.kinoxpbackend.model.Enum.AgeLimit;
import com.example.kinoxpbackend.model.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int movieID;
    private String imageURL;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int duration;
    @Enumerated(EnumType.STRING)
    private AgeLimit ageLimit;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MovieRuns> movieRuns;
}
