package com.capge.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class PersonDTO {
	@NotEmpty
	@Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Put an Employee valid name")
	private String name;
	@NotEmpty
	private String address;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@Pattern(regexp = "[0-9]{6}", message = "Put a proper zip code")
	@NotEmpty
	private String zipCode;
	@Pattern(regexp = "[0-9]{2}[ ][0-9]{10}", message = "Put a proper phone number")
	@NotEmpty
	private String phoneNumber;
}
