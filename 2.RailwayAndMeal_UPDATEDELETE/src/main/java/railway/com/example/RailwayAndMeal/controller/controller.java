package railway.com.example.RailwayAndMeal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping("/ticket")
	public void addTicket(@RequestBody Ticket ticket) {
		railwayservice.addTicket(ticket);
	}

	@GetMapping("/tickets")
	public List<Ticket> getAllTickets() {
		return railwayservice.getAllTickets();
	}

	@GetMapping("/ticket/{pnr}")
	public Ticket getTicketByPnr(@PathVariable long pnr) {
		return railwayservice.getTicketByPnr(pnr);
	}

	/*
	 * 1. Call the required service method
	 * 2. Add proper annotations for Delete Mapping and fetch the
	 * PNR from PathVariable.
	 */

	@DeleteMapping("ticket/{pnr}")
	public Ticket deleteTicket(@PathVariable long pnr) {
		Ticket ticket = getTicketByPnr(pnr);
		railwayservice.deleteTicketByPnr(pnr);
		return ticket;
	}

	/*
	 * 1. Call the required service method
	 * 2. Add proper annotations for Update Mapping and use RequestBody
	 * annotation to bind the request body to ticket.
	 */

	@PutMapping("ticket")
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		railwayservice.updateTicket(ticket);
		return ticket;
	}

}
