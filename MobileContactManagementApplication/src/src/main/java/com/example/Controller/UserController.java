package com.example.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(method= RequestMethod.POST,consumes = "application/json")
	public void create(@RequestBody User user) {
		userRepository.save(user);
	}
	//read
	
	@RequestMapping(value= "/{id}")
	public User read(@PathVariable String id) {
		User user = userRepository.findOneByName(id);
		if(user ==null)
			throw new UsertNotFoundException(" " + id);

		return userRepository.findOneByName(id);		
	}	
	
	
	@RequestMapping(method= RequestMethod.DELETE,value= "/{id}")
	public void delete(User user) {
		userRepository.delete(user);
	}
}
