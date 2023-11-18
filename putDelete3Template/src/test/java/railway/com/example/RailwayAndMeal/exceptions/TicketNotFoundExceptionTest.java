package railway.com.example.RailwayAndMeal.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Testing for Custom Exception - TicketNotFoundException")
public class TicketNotFoundExceptionTest {

    @Test
    @DisplayName("Testing for TicketNotFoundException Constructor")
    void testConstructor(){
        TicketNotFoundException notFoundException=  new TicketNotFoundException("No Ticket found with given id");
        String msg="No Ticket found with given id";
        assertNull(notFoundException.getCause());
        assertEquals(0, notFoundException.getSuppressed().length);
        assertEquals(msg, notFoundException.getMessage());
    }
}
