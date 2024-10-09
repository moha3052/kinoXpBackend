package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;


@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
}
