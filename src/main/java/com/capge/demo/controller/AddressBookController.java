package com.capge.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public String addContact(@PathVariable("contactId")	Long contactId) {
		return "Contact created for id = " + contactId;
	}

	@PutMapping("/update/{contactId}")
	public String updateContactData(@PathVariable("contactId") Long contactId){
		return "Contact updated for id = " + contactId;
	}

	@DeleteMapping("/delete/{empId}")
	public String deleteContactById(@PathVariable("empId") Long contactId) {
		return "Deleted the employee with id : " + contactId;
	}
}
