package railway.com.example.RailwayAndMeal.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Testing for Custom Exception - TicketAlreadyExistException")
public class TicketAlreadyExistsExceptionTest {
    @Test
    @DisplayName("Testing for TicketAlreadyExistException Constructor")
    void testConstructor(){
        String message="Ticket Already Exists";
        TicketAlreadyExistsException ticketAlreadyExistsException=new TicketAlreadyExistsException("Ticket Already Exists");
        assertNull(ticketAlreadyExistsException.getCause());
        assertEquals(0, ticketAlreadyExistsException.getSuppressed().length);
        assertEquals( message,ticketAlreadyExistsException.getMessage());
}}
