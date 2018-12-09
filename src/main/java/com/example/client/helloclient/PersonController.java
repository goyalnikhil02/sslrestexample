package com.example.client.helloclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonRepository repo;

	//@LogExecutionTime
	@GetMapping("/hello")
	public String hello() {
		return "Hi";
	}
	
	
	@RequestMapping("/list")
	public List<Person> listPerson() {
		return repo.findAll();
	}
	@RequestMapping("/{id}")
	public Person getByID(@PathVariable Integer id)
	{
		return repo.findOne(id);
		
	}
}
