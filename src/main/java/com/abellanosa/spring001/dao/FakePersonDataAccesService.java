package com.abellanosa.spring001.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.abellanosa.spring001.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccesService implements PersonDao{

	private static List<Person> DB = new ArrayList<Person>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}

	@Override
	public int deletePersonByID(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePersonByID(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Person> selectPersonByID(UUID id) {
		Person foundPerson;
		
//		for (Person person : DB) {
//			if(person.getId().equals(id)) {
//				foundPerson = person;
//				break;
//			}
//		}
		
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}
}
