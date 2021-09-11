package curso.personapi.domain.dto;

import curso.personapi.domain.entity.Phone;
import curso.personapi.domain.enums.PhoneType;

public class PhoneDTO {

	// Attributes
	private Long id;
	private PhoneType type;
	private String number;

	// Constructors
	public PhoneDTO() {

	}

	public PhoneDTO(Long id, PhoneType type, String number) {
		this.id = id;
		this.type = type;
		this.number = number;
	}

	public PhoneDTO(Phone phone) {
		this.id = phone.getId();
		this.type = phone.getType();
		this.number = phone.getNumber();
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
