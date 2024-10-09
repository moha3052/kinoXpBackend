package com.example.kinoxpbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

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
    private String theater;
    }

