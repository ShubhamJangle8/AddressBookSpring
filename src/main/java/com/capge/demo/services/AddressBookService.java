package com.capge.demo.services;

import org.springframework.stereotype.Service;

import com.capge.demo.dto.PersonDTO;

@Service
public class AddressBookService implements IPersonService{

	@Override
	public String getContactData() {
		return "Got the Contact";
	}

	@Override
	public String getContactById(Long id) {
		return "Contact for id " + id + " = Shubham";
	}

	@Override
	public String addContact(Long contactId, PersonDTO personDTO) {
		return "Contact created for Id " + contactId;
	}

	@Override
	public String updateContact(Long contactId) {
		return "Contact updated for Id " + contactId;
	}

	@Override
	public String deleteContact(Long contactId) {
		return "Contact deleted for Id " + contactId;
	}
	

}
