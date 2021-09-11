package curso.personapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.personapi.domain.dto.PersonDTO;
import curso.personapi.domain.dto.PhoneDTO;
import curso.personapi.domain.entity.Person;
import curso.personapi.domain.entity.Phone;
import curso.personapi.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	@Autowired

	@Transactional(readOnly = true)
	public List<PersonDTO> findAll() {
		List<Person> list = repository.findAll();
		return list.stream().map(person -> new PersonDTO(person)).collect(Collectors.toList());
	}

	@Transactional
	public PersonDTO createPerson(PersonDTO dto) {
		Person person = new Person(null, dto.getFirstName(), dto.getLastName(), dto.getCpf(), dto.getBirthDate());
		for (PhoneDTO phoneDTO : dto.getPhones()) {
			Phone phone = new Phone(null, phoneDTO.getType(), phoneDTO.getNumber());
			person.getPhones().add(phone);
		}
		repository.save(person);
		return new PersonDTO(person);
	}

	@Transactional
	public PersonDTO findByCpf(String cpf) {
		Optional<Person> person = repository.findByCpf(cpf);
		if (person.isEmpty()) {
			throw new IllegalArgumentException("CPF inválido");
		}
		return new PersonDTO(person.get());
	}

	@Transactional
	public PersonDTO removePerson(Long id) {
		Optional<Person> person = repository.findById(id);
		if (person.isEmpty()) {
			throw new IllegalArgumentException("ID inválido");
		}
		repository.delete(person.get());
		return new PersonDTO(person.get());
	}

}
