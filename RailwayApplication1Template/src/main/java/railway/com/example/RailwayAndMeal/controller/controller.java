package railway.com.example.RailwayAndMeal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.service.RailwayService;

@RestController
@RequestMapping("/railway")
public class controller {

	@Autowired
	private RailwayService railwayservice;		
	
	/*
	 1. Call the required service method
	 2. Add proper annotations for Post Mapping and attaching the
	 RequestBody.
	 */
	@PostMapping("/ticket")
	public void addTodo(@RequestBody Ticket ticket) {
		railwayservice.addTicket(ticket);
	}
	
	/*
	 1. Call the required service method
	 2. Add proper annotations for Get Mapping.
	 */
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets(){
		return railwayservice.getAllTickets();
	}
	
	/*
	 1. Call the required service method.
	 2. Add proper annotations for Get Mapping and attaching the
	 Path Variable to the method parameter.
	 */

	 @GetMapping("/ticket/{pnr}")
	public Ticket getTicketByPnr(@PathVariable long pnr) {
		return railwayservice.getTicketByPnr(pnr);
	}	

}
