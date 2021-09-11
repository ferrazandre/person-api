package curso.personapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.personapi.domain.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
