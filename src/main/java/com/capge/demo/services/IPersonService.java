package com.capge.demo.services;

import java.util.List;

import com.capge.demo.dto.PersonDTO;
import com.capge.demo.exceptions.AddressBookException;
import com.capge.demo.model.PersonData;

public interface IPersonService {
	public List<PersonData> getContactData();
	public PersonData getContactById(Long id) throws AddressBookException;
	public PersonData addContact(PersonDTO personDTO);
	public PersonData updateContactById(Long contactId, PersonDTO personDTO) throws AddressBookException;
	public void deleteContact(Long contactId) throws AddressBookException;
	public List<PersonData> getAllContacts();
	
}
