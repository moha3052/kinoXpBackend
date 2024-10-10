package com.example.kinoxpbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MovieRuns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "movieRuns", cascade = CascadeType.ALL)
    private List<Booking> bookings;
    }

