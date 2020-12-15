package com.capge.demo.model;

import com.capge.demo.dto.PersonDTO;

public class PersonData {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	
	public PersonData(Integer id, PersonDTO personDTO){
		this.id = id;
		this.firstName = personDTO.getFirstName();
		this.lastName = personDTO.getLastName();
		this.address = personDTO.getAddress();
		this.city = personDTO.getCity();
		this.state = personDTO.getState();
		this.zipCode = personDTO.getZipCode();
		this.phoneNumber = personDTO.getPhoneNumber();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
