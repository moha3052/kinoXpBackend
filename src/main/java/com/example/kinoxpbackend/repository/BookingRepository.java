package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBySeatId(Long id);
}
