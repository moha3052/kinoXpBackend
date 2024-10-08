package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieID(Long movieID);
}
