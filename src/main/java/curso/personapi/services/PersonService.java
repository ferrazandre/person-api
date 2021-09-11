package curso.personapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.personapi.domain.entity.Person;
import curso.personapi.repositorys.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public Person createPerson() {
		return null;
	}
}
