package com.example.kinoxpbackend.config;
import com.example.kinoxpbackend.repository.CinemaRepository;
import com.example.kinoxpbackend.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;

public class InitData implements CommandLineRunner {

    final MovieRepository movieRepository;
    final CinemaRepository cinemaRepository;

    public InitData(MovieRepository movieRepository, CinemaRepository cinemaRepository){
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
    }
    @Override
    public void run(String... args) throws Exception {

    }
}
