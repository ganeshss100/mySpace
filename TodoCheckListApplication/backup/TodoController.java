package com.example.webapp;

import java.util.Date;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.web.model.Todo;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	
	@RequestMapping(value="/todo-list",method = RequestMethod.GET)
	public String showTodoList(ModelMap model) {	
		String name = (String) model.get("name");				
		model.put("userList", service.retrieveTodos(name));		
		return "todoList";
	}
	
	@RequestMapping(value="/add-todo",method= RequestMethod.GET)
	public String addTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, (String) model.get("name"), "Default Desc",new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		System.out.println("id"+id);
		service.deleteTodo(id);
		return "redirect:/todo-list";
	}
	
	@RequestMapping(value="/add-todo",method = RequestMethod.POST)
	public String addTodoList(@RequestParam String desc, ModelMap model, @Valid Todo todo,BindingResult result) {
		System.out.println("Todo COntroller");
		if(result.hasErrors()) {
			return "todo";
		}
		service.addTodo((String) model.get("name"), desc, new Date(), false);
		return "redirect:/todo-list";
		
	}
}
