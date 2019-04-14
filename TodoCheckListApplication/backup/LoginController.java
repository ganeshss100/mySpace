package com.example.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
public String loginMessage() {
	//model.put("name1", name);
		return "login";	
}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String showWelcome(@RequestParam String name,@RequestParam String password, ModelMap model) {
		System.out.println("Start  name : "+name+"pass "+password);
		boolean validateUser = service.validateUser(name, password);
		
		if(!validateUser) {
		model.put("errorMessage", "Invalid credentials");
			return "login";
		}
		
		model.put("name", name);
		model.put("password",password);
		name = null;
		password = null;
		System.out.println("end name : "+name+"pass "+password);
		return "welcome";
		
	}
}
