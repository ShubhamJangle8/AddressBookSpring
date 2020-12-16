package com.capge.demo.services;

import java.util.List;

import com.capge.demo.dto.PersonDTO;
import com.capge.demo.exceptions.AddressBookException;
import com.capge.demo.model.PersonData;

public interface IPersonService {
	public List<PersonData> getContactData();
	public PersonData getContactById(Integer id) throws AddressBookException;
	public List<PersonData> addContact(PersonDTO personDTO);
	public PersonData updateContact(Integer contactId, PersonDTO personDTO) throws AddressBookException;
	public void deleteContact(Integer contactId) throws AddressBookException;
	
}
