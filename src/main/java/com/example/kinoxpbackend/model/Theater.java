package com.example.kinoxpbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterID;
    private String theater_name;
    private String seatRow;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<MovieRuns> movieRuns;
}
