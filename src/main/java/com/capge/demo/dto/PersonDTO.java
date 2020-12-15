package com.capge.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class PersonDTO {
	@NotEmpty
	@Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Put an Employee valid name")
	private String firstName;
	@NotEmpty
	@Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Put an Employee valid name")
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	
}
