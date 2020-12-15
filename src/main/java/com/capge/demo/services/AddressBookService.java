package com.capge.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capge.demo.dto.PersonDTO;
import com.capge.demo.model.PersonData;

@Service
public class AddressBookService implements IPersonService {
	List<PersonData> personList = new ArrayList<>();

	@Override
	public List<PersonData> getContactData() {
		return personList;
	}

	@Override
	public PersonData getContactById(Integer id) {
		return personList.get(id-1);
	}

	@Override
	public List<PersonData> addContact(PersonDTO personDTO) {
		PersonData personData = new PersonData(personList.size()+1, personDTO);
		personList.add(personData);
		return personList;
	}

	@Override
	public PersonData updateContact(Integer contactId, PersonDTO personDTO) {
		PersonData personData = this.getContactById(contactId);
		personData.setFirstName(personDTO.getFirstName());
		personData.setLastName(personDTO.getLastName());
		personData.setAddress(personDTO.getAddress());
		personData.setCity(personData.getCity());
		personData.setState(personDTO.getState());
		personData.setZipCode(personDTO.getZipCode());
		personData.setPhoneNumber(personDTO.getPhoneNumber());
		personList.set(contactId-1, personData);
		return personData;
	}

	@Override
	public void deleteContact(Integer contactId) {
		personList.remove(contactId-1);
	}

}
