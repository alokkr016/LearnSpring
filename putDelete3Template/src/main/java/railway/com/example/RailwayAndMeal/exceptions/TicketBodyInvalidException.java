package railway.com.example.RailwayAndMeal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//add proper annotation for this custom exception class
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TicketBodyInvalidException extends RuntimeException {

    //complete the method body for TicketBodyInvalidException constructor
    public TicketBodyInvalidException(String message) {
        super(message);
    }
}
