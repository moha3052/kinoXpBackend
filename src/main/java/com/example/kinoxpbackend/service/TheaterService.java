package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Theater;
import com.example.kinoxpbackend.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> assignTheater(int theaterID) {
        return theaterRepository.findByTheaterID(theaterID);
    }


}
