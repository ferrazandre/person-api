package curso.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.personapi.domain.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	public Person findByCpf(String cpf);
}
