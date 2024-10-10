package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.model.MovieRuns;
import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return bookingService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}/shows")
    public Optional<MovieRuns> getShowsForMovie(@PathVariable int movieId) {
        return bookingService.getShowsForMovie(movieId);
    }

    @GetMapping("/shows/{showId}/seats")
    public Optional<Seat> getAvailableSeats(@PathVariable int showId) {
        return bookingService.getAvailableSeatsForShow(showId);
    }

}
