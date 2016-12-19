package com.template.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.template.bean.Person;
import com.template.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonCtrl {

	private PersonService personService;
	
	@Autowired
	public PersonCtrl(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value="/all", method = RequestMethod.GET)
	public List<Person> getAll(){
		return personService.getAllPeople();
	}
	
	@RequestMapping(value="/{id}", method =RequestMethod.GET)
	public Person getById(@PathVariable long id){
		return personService.getById(id);
	}
	
	@RequestMapping(value="/save")
	public String create(String name, String lastname, long age,String profession) {
		Person person = new Person(name, lastname, age, profession);
		return personService.persist(person); 
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
	public Person updatePerson(@RequestBody Person person){
		return personService.update(person);
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deletePerson(@PathVariable long id){
		return personService.delete(id);
	}
	
	@RequestMapping(value="/find/{name}")
	public Person findByName(@PathVariable String name){
		return personService.findByName(name);
	}
	
	@RequestMapping(value="/findAge/{age}")
	public Person findByAge(@PathVariable long age){
		return personService.findByAge(age);
	}
}

