package curso.personapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.personapi.domain.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
