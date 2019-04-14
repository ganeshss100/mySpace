package com.example.model;

import org.springframework.data.annotation.Id;

public class User {

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(long mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getEmail() {
		return Secondaryemail;
	}
	public void setEmail(String email) {
		this.Secondaryemail = email;
	}
	@Id
	private String id;
	private String name;
	private long mobNumber;
	private String Secondaryemail;
}
