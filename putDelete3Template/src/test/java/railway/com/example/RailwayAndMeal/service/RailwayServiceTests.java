package railway.com.example.RailwayAndMeal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.exceptions.TicketAlreadyExistsException;
import railway.com.example.RailwayAndMeal.exceptions.TicketNotFoundException;

@SpringBootTest
@DisplayName("Testing for RailwayService")
@AutoConfigureMockMvc
public class RailwayServiceTests {

  @Autowired
  private RailwayService railwayService;

  @MockBean
  private Map<Long, Ticket> ticketMap;

  @Test
  @DisplayName("Testing getTicketByPnr for existing ticket")
  void testGetTicketByPnrExisting() {
    when(ticketMap.get(1L)).thenReturn(null);

    TicketNotFoundException exception = assertThrows(TicketNotFoundException.class,
            () -> railwayService.getTicketByPnr(1L));

    assertEquals("No ticket found with pnr : 1", exception.getMessage());
  }

  @Test
  @DisplayName("Testing addTicket for new ticket")
  void testAddTicketNew() {
    Ticket ticket = new Ticket("Name", 1L, 1L, "Birth");
    when(ticketMap.get(1L)).thenReturn(null);

    assertThrows(TicketAlreadyExistsException.class , () -> railwayService.addTicket(ticket));
  }

  @Test
  @DisplayName("Testing addTicket for existing ticket")
  void testAddTicketExisting() {
    Ticket ticket = new Ticket("Name", 1L, 1L, "Birth");
    when(ticketMap.get(1L)).thenReturn(ticket);

    TicketAlreadyExistsException exception = assertThrows(TicketAlreadyExistsException.class,
            () -> railwayService.addTicket(ticket));

    assertEquals("Ticket with id : 1 already exists", exception.getMessage());
  }

  @Test
  @DisplayName("Testing getAllTickets")
  void testGetAllTickets() {
    Ticket ticket1 = new Ticket("Name1", 1L, 1L, "Birth1");
    Ticket ticket2 = new Ticket("Name2", 2L, 2L, "Birth2");

    List<Ticket> expectedTickets = new ArrayList<>();
    expectedTickets.add(ticket1);
    expectedTickets.add(ticket2);

    railwayService.list = expectedTickets;

    List<Ticket> result = railwayService.getAllTickets();

    assertEquals(expectedTickets, result);
  }

  @Test
  @DisplayName("Testing deleteTicketByPnr")
  void testDeleteTicketByPnr() {
    Ticket ticket = new Ticket("Name", 1L, 1L, "Birth");
    when(ticketMap.get(1L)).thenReturn(ticket);

    assertThrows(TicketNotFoundException.class, () -> railwayService.deleteTicketByPnr(1L));
  }

  @Test
  @DisplayName("Testing updateTicket")
  void testUpdateTicket() {
    Ticket existingTicket = new Ticket("Name", 1L, 1L, "Birth");
    Ticket updatedTicket = new Ticket("Updated Name", 1L, 1L, "Updated Birth");

    when(ticketMap.get(1L)).thenReturn(existingTicket);

    assertThrows((TicketNotFoundException.class), ()-> railwayService.updateTicket(updatedTicket));

  }
}

