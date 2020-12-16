package com.capge.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capge.demo.dto.PersonDTO;

import lombok.Data;
@Entity
@Table(name = "person")
public @Data class PersonData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	
	public PersonData() {
		
	}
	
	public PersonData(PersonDTO personDTO) {
		this.updateEmployeePayrollData(personDTO);
	}

	public void updateEmployeePayrollData(PersonDTO personDTO) {
		this.name = personDTO.getName();
		this.address = personDTO.getAddress();
		this.city = personDTO.getCity();
		this.state = personDTO.getState();
		this.zipCode = personDTO.getZipCode();
		this.phoneNumber = personDTO.getPhoneNumber();
	}
	
}
