package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.MovieRuns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<MovieRuns, Integer> {
    //List<Show> findByMovieID(int movieID);
}
