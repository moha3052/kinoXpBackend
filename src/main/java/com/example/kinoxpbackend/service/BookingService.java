package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.model.Show;
import com.example.kinoxpbackend.repository.MovieRepository;
import com.example.kinoxpbackend.repository.SeatRepository;
import com.example.kinoxpbackend.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Show> getShowsForMovie(int movieId) {
        return showRepository.findByMovieID(movieId);
    }

    public List<Seat> getAvailableSeatsForShow(int seatId) {
        return seatRepository.findBySeatId(seatId);
    }
}

