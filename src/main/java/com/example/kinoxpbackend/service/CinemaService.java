package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Cinema;
import com.example.kinoxpbackend.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
    private CinemaRepository cinemaRepository;
    public CinemaService(CinemaRepository repository){
        this.cinemaRepository = repository;
    }
    public List<Cinema> getAllCinema(){
        return cinemaRepository.findAll();
    }
    public Cinema addCinema(Cinema cinema){
        return cinemaRepository.save(cinema);
    }
    public Optional<Cinema> getCinemaByID(int iD){
        return cinemaRepository.findById(iD);
     }
     public Cinema updateCinema(int iD, Cinema cinemaObject){
        Cinema cinema=cinemaRepository.findById(iD).orElse(null);
        if (cinema != null){
            cinema.setLocation(cinemaObject.getLocation());
            cinema.setName(cinemaObject.getName());
        return cinemaRepository.save(cinema);
        }
        return null;
    }
    public void deleteCinemaById(int  id){
        cinemaRepository.deleteById(id);
    }
}
