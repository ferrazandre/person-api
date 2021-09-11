package curso.personapi.domain.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import curso.personapi.domain.entity.Person;

public class PersonDTO {

	// Attributes
	private Long id;
	private String firstName;
	private String lastName;
	private String cpf;
	private LocalDate birthDate;
	private List<PhoneDTO> phones;

	// Constructors
	public PersonDTO() {
	}

	public PersonDTO(Long id, String firstName, String lastName, String cpf, LocalDate birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}

	public PersonDTO(Person person) {
		this.id = person.getId();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.cpf = person.getCpf();
		this.birthDate = person.getBirthDate();
		this.phones = person.getPhones().stream().map(phone -> new PhoneDTO(phone)).collect(Collectors.toList());
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

}
