package com.capge.demo.model;

import com.capge.demo.dto.PersonDTO;

import lombok.Data;

public @Data class PersonData {
	
	private Integer id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	
	public PersonData(Integer id, PersonDTO personDTO){
		this.id = id;
		this.name = personDTO.getName();
		this.address = personDTO.getAddress();
		this.city = personDTO.getCity();
		this.state = personDTO.getState();
		this.zipCode = personDTO.getZipCode();
		this.phoneNumber = personDTO.getPhoneNumber();
	}
	
}
