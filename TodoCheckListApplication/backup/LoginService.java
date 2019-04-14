package com.example.webapp;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String name, String password) {
		System.out.println("name : "+name+"pass "+password);
		return name.equalsIgnoreCase("ganesh")&& password.equalsIgnoreCase("123");
	}

}
