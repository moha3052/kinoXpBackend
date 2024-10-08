package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Show;
import com.example.kinoxpbackend.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    // Opret et nyt show
    public Show createShow(Show show) {
        // Validering for overlapping shows
        if (isOverlapping(show)) {
            throw new IllegalArgumentException("Show overlaps with an existing show in the same theater.");
        }
        return showRepository.save(show);
    }

    // Hent alle shows
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    // Valider om der er overlap mellem shows
    private boolean isOverlapping(Show newShow) {
        List<Show> existingShows = showRepository.findAll();
        for (Show show : existingShows) {
            if (show.getTheater().equals(newShow.getTheater())) {
                if (newShow.getStartTime().isBefore(show.getEndTime()) && newShow.getEndTime().isAfter(show.getStartTime())) {
                    return true; // Der er overlap
                }
            }
        }
        return false; // Ingen overlap
    }
}
