package railway.com.example.RailwayAndMeal.controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ObjectUtils;
import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.service.RailwayService;

@ContextConfiguration(classes = {controller.class})
@DisplayName("Testing for controler")
@ExtendWith(SpringExtension.class)
class controllerTest {
  @Autowired
  private controller controller;

  @MockBean
  private RailwayService railwayService;


  @Test
  @DisplayName("Testing GET /railway/tickets")
  @Order(2)
  void testGetAllTickets() throws Exception {
    when(railwayService.getAllTickets()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/railway/tickets");
    MockMvcBuilders.standaloneSetup(controller)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }


  @Test
  @DisplayName("Testing GET /railway/ticket/{pnr}")
  @Order(3)
  void testGetTicketByPnr() throws Exception {
    when(railwayService.getTicketByPnr(anyLong())).thenReturn(new Ticket("Name", 1L, 1L, "Birth"));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/railway/ticket/{pnr}", 1L);
    MockMvcBuilders.standaloneSetup(controller)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(
                    MockMvcResultMatchers.content().string("{\"pnr\":1,\"name\":\"Name\",\"age\":1,\"birth\":\"Birth\"}"));
  }


  @Test
  @DisplayName("Testing DELETE /railway/ticket/{pnr}")
  @Order(5)
  void testDeleteTicket() throws Exception {
    doNothing().when(railwayService).deleteTicketByPnr(anyLong());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/railway/ticket/{pnr}", 1L);
    MockMvcBuilders.standaloneSetup(controller)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @DisplayName("Testing for Post /railway/ticket")
  @Order(1)
  void testAddTicket() throws Exception {
    Ticket ticket = new Ticket("Name", 1L, 1L, "Birth");
    doNothing().when(railwayService).addTicket(ticket);

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonObj = objectMapper.writeValueAsString(ticket);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/railway/ticket");
    requestBuilder
            .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonObj);
    MockMvcBuilders.standaloneSetup(controller)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @DisplayName("Testing for PUT /railway/ticket")
  @Order(4)
  void testUpdateTicket() throws Exception {
    Ticket ticket = new Ticket("Name", 1L, 1L, "Birth");
    doNothing().when(railwayService).updateTicket(ticket);

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonObj = objectMapper.writeValueAsString(ticket);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/railway/ticket");
    requestBuilder
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonObj);
    MockMvcBuilders.standaloneSetup(controller)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk());
  }

}

