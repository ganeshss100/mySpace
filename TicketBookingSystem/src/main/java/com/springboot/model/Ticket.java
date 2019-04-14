package com.springboot.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.springboot.MongoDBapplication.redbusWebNdb.Passenger;

public class Ticket {
	@Id
	private int ticketNo;
	private String busNo;
	private List<String> seatNo;
	private List<Passenger> passengerDetails;
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public List<String> getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(List<String> seatNo) {
		this.seatNo = seatNo;
	}
	public List<Passenger> getPassengerDetails() {
		return passengerDetails;
	}
	public void setPassengerDetails(List<Passenger> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}	
}
