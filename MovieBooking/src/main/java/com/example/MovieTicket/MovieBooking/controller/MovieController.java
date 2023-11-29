package com.example.MovieTicket.MovieBooking.controller;

import com.example.MovieTicket.MovieBooking.Exceptions.MovieIdAlreadyExists;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class MovieController {

    @Autowired
    MovieServiceImpl movieServiceImpl;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieServiceImpl.getAllMovies();
    }

    @PostMapping("/movie")
    public void addMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Request Not Valid");
        }
        movieServiceImpl.addMovie(movie);
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable String id) {
        return movieServiceImpl.getMovieById(id);
    }

    @PutMapping("/update/{id}")
    public void updateMovie(@Valid @RequestBody Movie movie,@PathVariable String id) {
        movieServiceImpl.updateMovie(movie,id);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieServiceImpl.deleteMovie(id);
    }

}
