package com.example.kinoxpbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int movieID;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int duration;
    @Enumerated(EnumType.STRING)
    private AgeLimit ageLimit;
}
