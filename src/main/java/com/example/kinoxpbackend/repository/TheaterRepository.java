package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository <Theater, Integer> {
    List<Theater> findByTheaterID(int theaterID);
}
