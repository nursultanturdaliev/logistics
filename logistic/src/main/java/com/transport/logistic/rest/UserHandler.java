package com.transport.logistic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.transport.logistic.entities.Fracht;
import com.transport.logistic.repo.FrachtRepository;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserHandler {
	
	@Autowired
    FrachtRepository frachtRepository;
	
	@PostMapping("/saveLoad")
	public Fracht createNote(@RequestBody Fracht load) {
		frachtRepository.save(load);
		return null;

	}
	
	@GetMapping("/api/register")
	public String getLoad() {
		System.out.println("i was hier");
		return "Hi ich bin es";

	}
	


}
 