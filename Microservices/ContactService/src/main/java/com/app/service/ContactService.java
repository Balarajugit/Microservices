package com.app.service;

import com.app.request.ContactRequest;
import com.app.response.ContactResponse;

public interface ContactService {
	
	public ContactResponse createContact(ContactRequest requestData);
	
	public ContactResponse getContactById(Long id);

}
