package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Cinema;
import com.example.kinoxpbackend.service.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/cinema")
public class CinemaController {
    final CinemaService cinemaService;
    public CinemaController(CinemaService cinemaService){
        this.cinemaService = cinemaService;
    }
    @GetMapping
    public List<Cinema> getAllCinemas(){
        return cinemaService.getAllCinema();
    }
    @GetMapping("/{id}")
    public Optional<Cinema> getCinemaByID(@PathVariable int id){
        return cinemaService.getCinemaByID(id);
    }
    @PostMapping
    public Cinema createCinema(@RequestBody Cinema cinema){
        return cinemaService.addCinema(cinema);
    }
    @PutMapping("/{id}")
    public Cinema updateCinema(@PathVariable int id, @RequestBody Cinema cinemaBody){
        return  cinemaService.updateCinema(id,cinemaBody);
    }
    @DeleteMapping("/{id}")
    public void deleteCinema(@PathVariable int id){
        cinemaService.deleteCinemaById(id);
    }
}
