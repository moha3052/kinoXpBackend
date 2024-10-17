package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.MovieRuns;
import com.example.kinoxpbackend.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    // Opret et nyt show
    public MovieRuns createShow(MovieRuns movieRuns) {
        // Validering for overlapping shows
        if (isOverlapping(movieRuns)) {
            throw new IllegalArgumentException("Show overlaps with an existing show in the same theater.");
        }
        return showRepository.save(movieRuns);
    }

    // Hent alle shows
    public List<MovieRuns> getAllShows() {
        return showRepository.findAll();
    }

    public Optional<MovieRuns> getShowById(int showId) {
        return showRepository.findById(showId);
    }


    // Valider om der er overlap mellem shows
    private boolean isOverlapping(MovieRuns newMovieRuns) {
        List<MovieRuns> existingMovieRuns = showRepository.findAll();
        for (MovieRuns movieRuns : existingMovieRuns) {
            if (movieRuns.getTheater().equals(newMovieRuns.getTheater())) {
                if (newMovieRuns.getStartTime().isBefore(movieRuns.getEndTime()) && newMovieRuns.getEndTime().isAfter(movieRuns.getStartTime())) {
                    return true; // Der er overlap
                }
            }
        }
        return false; // Ingen overlap
    }
}
