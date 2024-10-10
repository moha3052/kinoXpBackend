package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.model.Theater;
import com.example.kinoxpbackend.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> assignTheater(int theaterID) {
        return theaterRepository.findByTheaterID(theaterID);
    }

    public List<Theater> getTheaters() {
        return theaterRepository.findAll();
    }

    public List<Theater> updateTheater(List<Theater> theaters) {
        return theaterRepository.saveAll(theaters);
    }

    public void deleteTheater(int theaterID) {
        theaterRepository.deleteById(theaterID);
    }

    public Theater createTheater(Theater theater) {
        // Oprette sæder for teateret
        Seat seat1 = new Seat();
        seat1.setSeatName("A1");
        seat1.setRowName("A");
        seat1.setTheater(theater);

        Seat seat2 = new Seat();
        seat2.setSeatName("A2");
        seat2.setRowName("A");
        seat2.setTheater(theater);

        List<Seat> seats = new ArrayList<>();
        seats.add(seat1);
        seats.add(seat2);

        // Sæt sæderne i teateret
        theater.setSeats(seats);

        // Gem teateret (dette vil også gemme sæderne på grund af cascade)
        return theaterRepository.save(theater);
    }
}
