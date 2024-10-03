package controller;

import model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.MovieService;

import java.util.List;
@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
    @Autowired
    private MovieService movieService;

    // Hent alle film
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Hent en film baseret på ID
     @GetMapping("/{id}")
    public List<Movie> getMovieById(@PathVariable int id) {
         List <Movie>movieById = movieService.getMovieById(id);
        if (movieById == null) {
            throw new RuntimeException("Film not found with ID: " + id);  // Kaste en exception, hvis filmen ikke findes
        }
        return movieById;
    }

    // Tilføj en ny film
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
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
