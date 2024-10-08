package com.example.kinoxpbackend.cinema;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/cinema")
@RestController
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
    public Optional<Cinema> getCinemaByID(@PathVariable Long id){
        return cinemaService.getCinemaByID(id);
    }
    @PostMapping
    public Cinema createCinema(@RequestBody Cinema cinema){
        return cinemaService.addCinema(cinema);
    }
    @PutMapping("/{id}")
    public Cinema updateCinema(@PathVariable Long id, @RequestBody Cinema cinemaBody){
        return  cinemaService.updateCinema(id,cinemaBody);
    }
    @DeleteMapping("/{id}")
    public void deleteCinema(@PathVariable Long id){
        cinemaService.deleteCinemaById(id);
    }
}
