package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    // Du kan tilføje tilpassede metoder her, hvis nødvendigt
}
