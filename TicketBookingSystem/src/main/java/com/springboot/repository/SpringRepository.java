package com.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.springboot.model.Ticket;

public interface SpringRepository extends MongoRepository<Ticket, String>{
	public Ticket findOneByTicketNo(int ticketNo);
}
