package com.example.kinoxpbackend.cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
//    List<Cinema> findAll(Long id);
}
