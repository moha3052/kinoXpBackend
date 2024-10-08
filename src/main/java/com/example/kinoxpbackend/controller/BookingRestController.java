package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.model.Show;
import com.example.kinoxpbackend.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class BookingRestController {
    private final BookingService bookingService;

    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return bookingService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}/shows")
    public List<Show> getShowsForMovie(@PathVariable int movieId) {
        return bookingService.getShowsForMovie(movieId);
    }

    @GetMapping("/shows/{showId}/seats")
    public List<Seat> getAvailableSeats(@PathVariable int showId) {
        return bookingService.getAvailableSeatsForShow(showId);
    }

}
