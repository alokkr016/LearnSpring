package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Exceptions.MovieIdAlreadyExists;
import com.example.MovieTicket.MovieBooking.Exceptions.MovieIdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {

    public List<Movie> list = new ArrayList<>();
    public Map<String, Movie> movieMap = new HashMap<>();

    @Override
    public List<Movie> getAllMovies() {
        return list;
    }

    @Override
    public void addMovie(Movie movie) {
        if (movieMap.get(movie.getId()) != null) {
            throw new MovieIdAlreadyExists("Movie already added");
        }
        list.add(movie);
        movieMap.put(movie.getId(), movie);
    }

    @Override
    public Movie getMovieById(String id) {
        if (ObjectUtils.isEmpty(movieMap.get(id))) {
            throw new MovieIdNotFound("Movie not found");
        }
        return movieMap.get(id);
    }

    @Override
    public void updateMovie(Movie movie, String id) {
        Movie existingMovie = getMovieById(id);

        list.remove(existingMovie);
        list.add(movie);
        movieMap.put(id, movie);

        Map<String, Long> updatedRating = new HashMap<>();
        updatedRating.put(id, movie.getMovieRating());

    }

    @Override
    public void deleteMovie(String id) {
        Movie movie = getMovieById(id);
        list.remove(movie);
        movieMap.remove(id);
    }
}
