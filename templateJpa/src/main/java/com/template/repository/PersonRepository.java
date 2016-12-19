package com.template.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.template.bean.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

	List<Person> findAllByOrderByAgeAsc();
	
	Person findById(Long id);
	
	@Query("select p from Person p where p.name = :name")
	Person findPersonByName(@Param("name") String name);
	
	@Query(value = "SELECT * FROM Person where age = :age", nativeQuery = true )
	Person findPersonByAgeNative(@Param("age") long age);
	
}
