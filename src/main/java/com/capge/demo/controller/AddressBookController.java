package com.capge.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capge.demo.dto.PersonDTO;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@GetMapping(value= {"/","","/home"})
	public String getContactData() {
		return "Got the contact";
	}

	@GetMapping("/get/{contactId}")
	public String getContactById(@PathVariable("contactId") Long contactId){
		return "Contact for id " + contactId + " = Shubham";
	}
		
	@PostMapping("/create/{contactId}")
	public ResponseEntity<String> addContact(@PathVariable("contactId") Long contactId, @RequestBody PersonDTO personDTO) {
		return new ResponseEntity<String>("Contact created for Id " + contactId, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<String> updateContactData(@PathVariable("contactId") Long contactId){
		return new ResponseEntity<String>("Contact updated for id = " + contactId, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteContactById(@PathVariable("empId") Long contactId) {
		return new ResponseEntity<String>("Contact deleted for id = " + contactId, HttpStatus.OK);
	}
}
