package com.template.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.bean.Person;
import com.template.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> getAllPeople(){
		return personRepository.findAllByOrderByAgeAsc();
	}

	public Person getById(long id) {
		return personRepository.findById(id);
	}

	public String persist(Person person) {
		try{
		  personRepository.save(person);
		}catch(Exception e){
			return e.getMessage();
		}
		return "person created successfully!";
	}
	
	public Person update(Person person){
		return personRepository.save(person);
	}
	
	public String delete(long id){	
	    try {
	      Person person = new Person(id);
		  personRepository.delete(person);	
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Person deleted!";
	}

	public Person findByName(String name) {
		return personRepository.findPersonByName(name);
	}

	public Person findByAge(long age) {
		return personRepository.findPersonByAgeNative(age);
	}
}
