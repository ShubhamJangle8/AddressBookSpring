package com.capge.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capge.demo.dto.PersonDTO;
import com.capge.demo.exceptions.AddressBookException;
import com.capge.demo.model.PersonData;
import com.capge.demo.repository.IPersonRepository;

@Service
public class AddressBookService implements IPersonService {
	@Autowired
	IPersonRepository personRepository;
	
	@Override
	public List<PersonData> getContactData() {
		return personRepository.findAll();
	}

	@Override
	public PersonData getContactById(Long id) throws AddressBookException {
		PersonData personData = personRepository.findById(id).orElseThrow(() -> new AddressBookException("Not a valid contact"));
		return personData;
	}
	
	@Override
	public List<PersonData> getAllContacts() {
		return personRepository.findAll();
	}

	@Override
	public PersonData addContact(PersonDTO personDTO) {
		PersonData personData = new PersonData(personDTO);
		personRepository.save(personData);
		return personData;
	}

	@Override
	public PersonData updateContactById(Long contactId, PersonDTO personDTO) throws AddressBookException {
		PersonData personData = personRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Not a valid contact"));
		personData.setName(personDTO.getName());
		personData.setAddress(personDTO.getAddress());
		personData.setCity(personDTO.getCity());
		personData.setState(personDTO.getState());
		personData.setZipCode(personDTO.getZipCode());
		personData.setPhoneNumber(personDTO.getPhoneNumber());
		return personData;
	}

	@Override
	public void deleteContact(Long contactId) throws AddressBookException {
		PersonData personData = personRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Not a valid contact"));
		personRepository.delete(personData);
	}

}
