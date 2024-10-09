package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.MovieRuns;
import com.example.kinoxpbackend.service.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowRestController {
    private final ShowService showService;

    public ShowRestController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public ResponseEntity<MovieRuns> createShow(@RequestBody MovieRuns movieRuns) {
        MovieRuns createdMovieRuns = showService.createShow(movieRuns);
        return ResponseEntity.ok(createdMovieRuns);
    }

    @GetMapping
    public ResponseEntity<List<MovieRuns>> getAllShows() {
        List<MovieRuns> movieRuns = showService.getAllShows();
        return ResponseEntity.ok(movieRuns);
    }
}
