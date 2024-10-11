package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Enum.AgeLimit;
import com.example.kinoxpbackend.model.Enum.Genre;
import com.example.kinoxpbackend.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.kinoxpbackend.service.MovieService;



import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/movies")
public class MovieRestController {

    final MovieService movieService;

    public MovieRestController(MovieService movieService){
        this.movieService = movieService;
    }
    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        System.out.println(movie.getTitle());
        if (movie == null) {
            return ResponseEntity.badRequest().body("Movie cannot be null");
        }
        // tilføjelse af andre valideringer her
        try {
            Movie savedMovie = movieService.createMovie(movie);
            return ResponseEntity.ok(savedMovie);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving movie: " + e.getMessage());
        }
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
