package com.example.MovieTicket.MovieBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieIdNotFound extends RuntimeException{
    public MovieIdNotFound(String message){
        super(message);
    }
}
