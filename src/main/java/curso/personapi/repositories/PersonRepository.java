package curso.personapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.personapi.domain.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	public Optional<Person> findByCpf(String cpf);
}
