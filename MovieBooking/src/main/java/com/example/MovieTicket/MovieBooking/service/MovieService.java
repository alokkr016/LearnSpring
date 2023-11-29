package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Model.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> getAllMovies();
    public void addMovie(Movie movie);
    public Movie getMovieById(String id);

    void updateMovie(Movie movie, String id);
    public void deleteMovie(String id);
}
