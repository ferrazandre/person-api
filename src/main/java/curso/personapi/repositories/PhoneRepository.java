package curso.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.personapi.domain.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
