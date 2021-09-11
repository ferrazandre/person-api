package curso.personapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.personapi.domain.dto.PhoneDTO;
import curso.personapi.domain.entity.Phone;
import curso.personapi.repositories.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
	private PhoneRepository repository;

	@Transactional
	public PhoneDTO createPhone(PhoneDTO dto) {
		Phone phone = new Phone(null, dto.getType(), dto.getNumber());
		repository.save(phone);
		return new PhoneDTO(phone);
	}

	@Transactional
	public void removePhone(Long id) {
		Optional<Phone> phone = repository.findById(id);
		if (phone.isEmpty()) {
			throw new IllegalArgumentException("ID inválido");
		}
		repository.delete(phone.get());
	}

	@Transactional(readOnly = true)
	public List<PhoneDTO> findAll() {
		List<Phone> list = repository.findAll();
		return list.stream().map(phone -> new PhoneDTO(phone)).collect(Collectors.toList());
	}
}
