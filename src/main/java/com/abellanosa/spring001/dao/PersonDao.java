package com.abellanosa.spring001.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.abellanosa.spring001.model.Person;

public interface PersonDao {
	
	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> selectAllPeople();
	
	int deletePersonByID(UUID id);
	
	int updatePersonByID(UUID id, Person person);
	
	Optional<Person> selectPersonByID(UUID id);
}
