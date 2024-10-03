package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Movie;
import repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Hent alle film
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Tilføj en ny film
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Hent en film baseret på ID
    public List<Movie> getMovieById(int id) {
        return movieRepository.findByid(id);
    }

    // Opdater en film
    public Movie updateMovie(int id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            movie.setTitle(movieDetails.getTitle());
            movie.setGenre(movieDetails.getGenre());
            movie.setDuration(movieDetails.getDuration());
            movie.setAgeLimit(movieDetails.getAgeLimit());
            return movieRepository.save(movie);
        }
        return null;
    }

    // Slet en film
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}
