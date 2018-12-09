package com.example.client.helloclient;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//https://medium.com/@gtommee97/rest-api-java-spring-boot-and-mongodb-4dffbcabbaf5
@RestController
@RequestMapping("/pets")
public class PetController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PetController.class);
	
	
	@Autowired
	private PetsRepository repository;

	//@LogExecutionTime
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Pets> getAllPets() {
		return repository.findAll();
	}

	//@LogExecutionTime
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pets getPetById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@LogExecutionTime
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
		pets.set_id(id);
		LOGGER.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		repository.save(pets);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Pets createPet(@Valid @RequestBody Pets pets) {
		pets.set_id(ObjectId.get());
		repository.save(pets);
		return pets;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePet(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}

}
