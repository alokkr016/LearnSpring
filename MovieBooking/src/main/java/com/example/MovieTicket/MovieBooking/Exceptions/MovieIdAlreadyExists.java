package com.example.MovieTicket.MovieBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieIdAlreadyExists extends RuntimeException{
    public MovieIdAlreadyExists(String message){
        super(message);
    }
}
