package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.AgeLimit;
import com.example.kinoxpbackend.model.Genre;
import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.repository.MovieRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final RestTemplate restTemplate;
    private final String api = "https://api.themoviedb.org/3/discover/movie?primary_release_year=2024&api_key=2b5953c6a0951ac2ba0f1d30493b74ec";

    public MovieService(MovieRepository movieRepository, RestTemplate restTemplate) {
        this.movieRepository = movieRepository;
        this.restTemplate = restTemplate;
    }

    // Tilføj en ny film
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Hent en film baseret på ID
    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElse(null);
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

    public List<Movie> getMovies() {
        try {
            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                    api,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Map<String, Object>>() {}
            );

            List<Map<String, Object>> results = (List<Map<String, Object>>) response.getBody().get("results");

            if (results == null) {
                return Collections.emptyList(); // Returner en tom liste, hvis der ikke er nogen resultater
            }

            List<Movie> movieList = results.stream()
                    .map(this::mapToMovie)
                    .collect(Collectors.toList());

            // Gem filmene i databasen
            saveMovies(movieList);

            return movieList;
        } catch (Exception e) {
            // Log fejl her, hvis nødvendigt
            return Collections.emptyList(); // Returner en tom liste ved fejl
        }
    }

    private Movie mapToMovie(Map<String, Object> result) {
        Movie movie = new Movie();
        movie.setTitle((String) result.get("title"));

        List<Integer> genreIds = (List<Integer>) result.get("genre_ids");
        if (genreIds != null && !genreIds.isEmpty()) {
            movie.setGenre(mapGenreIdToEnum(genreIds.get(0)));
        } else {
            movie.setGenre(Genre.UNKNOWN); // Standardværdi, hvis der ikke er nogen genre
        }

        // Håndter 'runtime'
        Integer runtime = (Integer) result.get("runtime");
        movie.setDuration(runtime != null ? runtime : 0);

        Integer ageLimitValue = (Integer) result.get("age_limit");
        movie.setAgeLimit(mapAgeLimitValueToEnum(ageLimitValue != null ? ageLimitValue : 0));

        return movie;
    }

    // Metode til at mappe genreId til Genre enum
    private Genre mapGenreIdToEnum(Integer genreId) {
        switch (genreId) {
            case 28: return Genre.ACTION;
            case 12: return Genre.ADVENTURE;
            case 16: return Genre.ANIMATION;
            case 35: return Genre.COMEDY;
            case 80: return Genre.CRIME;
            case 99: return Genre.DOCUMENTARY;
            case 18: return Genre.DRAMA;
            case 14: return Genre.FANTASY;
            case 27: return Genre.HORROR;
            case 9648: return Genre.MYSTERY;
            case 10749: return Genre.ROMANCE;
            case 878: return Genre.SCIENCE_FICTION;
            case 53: return Genre.THRILLER;
            case 10752: return Genre.WAR;
            case 37: return Genre.WESTERN;
            default: return Genre.UNKNOWN; // Standardværdi, hvis genreId ikke matcher
        }
    }

    // Metode til at mappe ageLimit værdi til AgeLimit enum
    private AgeLimit mapAgeLimitValueToEnum(Integer ageLimitValue) {
        switch (ageLimitValue) {
            case 0:
                return AgeLimit.G; // G for "General"
            case 1:
                return AgeLimit.PG; // PG for "Parental Guidance"
            case 2:
                return AgeLimit.PG_13; // PG-13 for "Parents Strongly Cautioned"
            case 3:
                return AgeLimit.R; // R for "Restricted"
            default:
                return AgeLimit.UNKNOWN; // Ukendt værdi
        }
    }

    // Metode til at gemme film i MySQL
    private void saveMovies(List<Movie> movies) {
        movieRepository.saveAll(movies);  // Gem alle film i databasen
    }
}
