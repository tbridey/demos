package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Pizza;
import com.revature.services.PizzaService;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService service;

	@GetMapping(path = "pizza", produces = "application/json")
	@ResponseBody
	public Set<Pizza> findAll() {
		return service.findAll();
	}
	
	@GetMapping("pizza/{id}")
	@ResponseBody
	public Pizza findById(@PathVariable("id") int id) {
		Set<Pizza> all = service.findAll();
		
		for(Pizza p : all) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}
	
	@PostMapping("pizza")
	@ResponseBody
	public Pizza insert(@RequestBody Pizza p) {
		service.save(p);
		
		return p;
	}
}
