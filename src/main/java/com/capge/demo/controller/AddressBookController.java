package com.capge.demo.controller;

import javax.validation.Valid;

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
import com.capge.demo.exceptions.AddressBookException;
import com.capge.demo.model.PersonData;
import com.capge.demo.services.IPersonService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	@Autowired
	IPersonService service;
	
	@GetMapping(value= {"/","","/home"})
	public ResponseEntity<ResponseDTO> getContactData() {
		ResponseDTO responseDTO = new ResponseDTO("Get call successful", service.getContactData());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("contactId") Integer contactId) throws AddressBookException{
		ResponseDTO responseDTO = new ResponseDTO("Get call successful", service.getContactById(contactId));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
		
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody PersonDTO personDTO) {
		ResponseDTO responseDTO = new ResponseDTO("Contact creation successfull", service.addContact(personDTO));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") Integer contactId,@Valid @RequestBody PersonDTO personDTO) throws AddressBookException{
		PersonData personData = service.updateContact(contactId, personDTO);
		ResponseDTO responseDTO = new ResponseDTO("Contact updation successfull", personData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteContactById(@PathVariable("empId") Integer contactId) throws AddressBookException {
		service.deleteContact(contactId);
		String message = "Contact deleted for id = " + contactId;
		ResponseDTO responseDTO = new ResponseDTO("Contact deletion successfull", message);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
