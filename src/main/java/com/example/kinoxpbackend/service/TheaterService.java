package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Theater;
import com.example.kinoxpbackend.repository.TheaterRepository;


import java.util.List;

public class TheaterService {
   final TheaterRepository theaterRepository;


    public TheaterService (TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> assignTheater(int theaterID) {
        return theaterRepository.findByTheaterID(theaterID);
    }

    public List<Theater> getTheaters() {
        return theaterRepository.findAll();
    }

    public List<Theater> updateTheater(List<Theater> theaters) {
      return  theaterRepository.saveAll(theaters);
    }

    public void deleteTheater(int theaterID) {
        theaterRepository.deleteById(theaterID);
    }

    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

}
