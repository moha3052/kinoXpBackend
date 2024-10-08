package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TheaterRepository extends JpaRepository <Theater, Integer> {
    List<Theater> findByTheaterID(int theaterID);
}
