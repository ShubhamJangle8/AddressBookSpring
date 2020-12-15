package com.capge.demo.controller;

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
import com.capge.demo.services.IPersonService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	@Autowired
	IPersonService service;
	
	@GetMapping(value= {"/","","/home"})
	public String getContactData() {
		return service.getContactData();
	}

	@GetMapping("/get/{contactId}")
	public String getContactById(@PathVariable("contactId") Long contactId){
		return service.getContactById(contactId); 
	}
		
	@PostMapping("/create/{contactId}")
	public ResponseEntity<ResponseDTO> addContact(@PathVariable("contactId") Long contactId, @RequestBody PersonDTO personDTO) {
		String message = service.addContact(contactId, personDTO);
		ResponseDTO responseDTO = new ResponseDTO("Contact creation successfull", message);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") Long contactId){
		String message = service.updateContact(contactId);
		ResponseDTO responseDTO = new ResponseDTO("Contact updation successfull", message);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteContactById(@PathVariable("empId") Long contactId) {
		String message = service.deleteContact(contactId);
		ResponseDTO responseDTO = new ResponseDTO("Contact deletion successfull", message);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
