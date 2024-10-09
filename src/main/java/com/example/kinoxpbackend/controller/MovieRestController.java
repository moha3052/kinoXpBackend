package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.kinoxpbackend.service.MovieService;


import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    final MovieService movieService;

    public MovieRestController(MovieService movieService){
        this.movieService = movieService;
    }

    // Hent alle film
    @GetMapping
    public List<Movie> getAllMovies() {

        return movieService.getMovies();
    }


    // Hent en film baseret på ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie Movie = movieService.getMovieById(id);
        if (Movie != null) {
            return ResponseEntity.ok(Movie);  // Kaste en exception, hvis filmen ikke findes
        }
        return ResponseEntity.notFound().build();
    }

    // Tilføj en ny film
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.createMovie(movie);  // Gem film i databasen
        return ResponseEntity.ok(savedMovie);  // Returner den gemte film som respons
    }


    // Opdater en eksisterende film
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movieDetails) {
        return movieService.updateMovie(id, movieDetails);
    }

    // Slet en film
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
    }
}
