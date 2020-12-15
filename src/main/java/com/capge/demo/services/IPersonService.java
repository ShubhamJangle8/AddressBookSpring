package com.capge.demo.services;

import com.capge.demo.dto.PersonDTO;

public interface IPersonService {
	public String getContactData();
	public String getContactById(Long id);
	public String addContact(Long contactId, PersonDTO personDTO);
	public String updateContact(Long contactId);
	public String deleteContact(Long contactId);
	
}
