package com.capge.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.capge.demo.dto.ResponseDTO;
import com.capge.demo.model.PersonData;
import com.capge.demo.services.IPersonService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	@Autowired
	IPersonService service;
	
	@GetMapping(value= {"/","","/home"})
	public ResponseEntity<ResponseDTO> getContactData() {
		List<PersonData> personList = null;
		personList = service.getContactData();
		ResponseDTO responseDTO = new ResponseDTO("Get call successful", personList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("contactId") Integer contactId){
		PersonData personData = null;
		personData = service.getContactById(contactId);
		ResponseDTO responseDTO = new ResponseDTO("Get call successful", personData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
		
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addContact(@RequestBody PersonDTO personDTO) {
		List<PersonData> personList = null;
		personList = service.addContact(personDTO);
		ResponseDTO responseDTO = new ResponseDTO("Contact creation successfull", personList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") Integer contactId, @RequestBody PersonDTO personDTO){
		PersonData personData = service.updateContact(contactId, personDTO);
		ResponseDTO responseDTO = new ResponseDTO("Contact updation successfull", personData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteContactById(@PathVariable("empId") Integer contactId) {
		service.deleteContact(contactId);
		String message = "Contact deleted for id = " + contactId;
		ResponseDTO responseDTO = new ResponseDTO("Contact deletion successfull", message);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
