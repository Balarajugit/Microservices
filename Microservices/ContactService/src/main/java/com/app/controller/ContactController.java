package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.request.ContactRequest;
import com.app.response.ContactResponse;
import com.app.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
	
	@Autowired
	public ContactService contactService;
	
	@PostMapping("/saveContact")
	public ContactResponse createContact(@RequestBody ContactRequest req) {
		
		return contactService.createContact(req);
	}
	
	
	@GetMapping("/get/{id}")
	public ContactResponse getContactById(@PathVariable Long id) {
		return contactService.getContactById(id);
	}
	

}
