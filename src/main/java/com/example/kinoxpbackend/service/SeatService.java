package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatService {

    final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeat(){
        return seatRepository.findAll();
    }

    public Seat createSeat(Seat seat){
        return seatRepository.save(seat);
    }

    public void deleteSeat(int id){
        seatRepository.findById(id);
    }

    private void saveSeats(List<Seat> seats) {
        seatRepository.saveAll(seats);  // Gem alle film i databasen
    }
}
