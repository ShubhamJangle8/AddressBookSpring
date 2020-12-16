package com.capge.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capge.demo.dto.PersonDTO;
import com.capge.demo.exceptions.AddressBookException;
import com.capge.demo.model.PersonData;

@Service
public class AddressBookService implements IPersonService {
	List<PersonData> personList = new ArrayList<>();

	@Override
	public List<PersonData> getContactData() {
		return personList;
	}

	@Override
	public PersonData getContactById(Integer id) throws AddressBookException {
		personList.stream().filter(personData -> personData.getId() == id).findFirst().orElseThrow(() -> new AddressBookException("Contact not found for this id"));
		return personList.get(id-1);
	}

	@Override
	public List<PersonData> addContact(PersonDTO personDTO) {
		PersonData personData = new PersonData(personList.size()+1, personDTO);
		personList.add(personData);
		return personList;
	}

	@Override
	public PersonData updateContact(Integer contactId, PersonDTO personDTO) throws AddressBookException {
		personList.stream().filter(personData -> personData.getId() == contactId).findFirst().orElseThrow(() -> new AddressBookException("Contact not found for this id"));
		PersonData personData = this.getContactById(contactId);
		personData.setName(personDTO.getName());
		personData.setAddress(personDTO.getAddress());
		personData.setCity(personData.getCity());
		personData.setState(personDTO.getState());
		personData.setZipCode(personDTO.getZipCode());
		personData.setPhoneNumber(personDTO.getPhoneNumber());
		personList.set(contactId-1, personData);
		return personData;
	}

	@Override
	public void deleteContact(Integer contactId) throws AddressBookException {
		personList.stream().filter(personData -> personData.getId() == contactId).findFirst().orElseThrow(() -> new AddressBookException("Contact not found for this id"));
		personList.remove(contactId-1);
	}

}
