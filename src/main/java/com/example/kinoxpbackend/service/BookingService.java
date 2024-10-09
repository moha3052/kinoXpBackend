package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.model.MovieRuns;
import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.repository.MovieRepository;
import com.example.kinoxpbackend.repository.SeatRepository;
import com.example.kinoxpbackend.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final MovieRepository movieRepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;

    public BookingService(MovieRepository movieRepository, ShowRepository showRepository, SeatRepository seatRepository) {
        this.movieRepository = movieRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<MovieRuns> getShowsForMovie(int movieId) {
        return showRepository.findById(movieId);
    }

    public Optional<Seat> getAvailableSeatsForShow(int seatId) {
        return seatRepository.findById(seatId);
    }
}

