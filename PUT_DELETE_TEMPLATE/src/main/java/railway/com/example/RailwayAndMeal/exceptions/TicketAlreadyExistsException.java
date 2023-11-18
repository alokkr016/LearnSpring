package railway.com.example.RailwayAndMeal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Annotation to specify that this is a custom exception
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TicketAlreadyExistsException extends RuntimeException {

    // Default constructor
    public TicketAlreadyExistsException() {
        super("Ticket already exists"); // Default message
    }

    // Constructor that takes a custom message as a parameter
    public TicketAlreadyExistsException(String message) {
        super(message);
    }
}
