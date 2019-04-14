package com.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.model.Ticket;
import com.springboot.repository.SpringRepository;

@RestController
@RequestMapping("/redbus")
public class TicketController {

	@Autowired
	SpringRepository springRepository;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", value="/bookTicket")
	public void bookTicket(@RequestBody Ticket ticket) {
		springRepository.save(ticket);
	}
	
	@RequestMapping(value= "/pnr/{ticketNo}")
	public Ticket read(@PathVariable int ticketNo) {
		return springRepository.findOneByTicketNo(ticketNo);		
	}
	
	
	/*@RequestMapping(method= RequestMethod.PUT,consumes = "application/json")
	public void update(Ticket ticket) {
		springRepository.save(ticket);
	}*/
	
	@RequestMapping(method= RequestMethod.DELETE,value= "/cancel/{ticketNo}")
	public void delete(Ticket ticket) {
		springRepository.delete(ticket);
	}
}


