package railway.com.example.RailwayAndMeal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Annotation to specify that this is a custom exception
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException {

    // Constructor that takes a custom message as a parameter
    public TicketNotFoundException(String message) {
        super(message);
    }
}
