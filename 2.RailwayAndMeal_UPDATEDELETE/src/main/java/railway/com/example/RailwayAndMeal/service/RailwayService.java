package railway.com.example.RailwayAndMeal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import railway.com.example.RailwayAndMeal.Entity.Ticket;

@Service
public class RailwayService {
	
	public List<Ticket> list = new ArrayList<>();
	public Map<Long,Ticket> ticketMap = new HashMap<>();
	
	public void addTicket(Ticket ticket) {
		list.add(ticket);
		ticketMap.put(ticket.getPnr(), ticket);	
	}
	
	public List<Ticket> getAllTickets() {		
		return list;
	}
	
	public Ticket getTicketByPnr(long pnr) {
		return ticketMap.get(pnr);
	}
	
	//Complete the method body to delete a ticket by PNR.
	public void deleteTicketByPnr(long pnr) {
		Ticket ticket = ticketMap.get(pnr);
		list.remove(ticket);
		ticketMap.remove(pnr);
	}
	
	//Complete the method body to update a existing ticket.
	public void updateTicket(Ticket ticket) {
		Ticket existingTicket = ticketMap.get(ticket.getPnr());
		list.remove(existingTicket);
		list.add(ticket);
		ticketMap.put(ticket.getPnr(), ticket); 
	}
}