package com.springboot.MongoDBapplication.redbusWebNdb;

import org.springframework.stereotype.Component;

@Component
public class Bus  {
	String busN0;
    String busType;
	public String getBusNameN0() {
		return busN0;
	}
	public void setBusNameN0(String busNameN0) {
		this.busN0 = busNameN0;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
}
