package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    //List<Seat> findBySeatId(int seatId);
}
