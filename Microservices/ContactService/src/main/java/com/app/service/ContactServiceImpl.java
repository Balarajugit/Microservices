package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Contact;
import com.app.repo.ContactRepository;
import com.app.request.ContactRequest;
import com.app.response.ContactResponse;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	public ContactRepository contactRepository;

	@Override
	public ContactResponse createContact(ContactRequest requestData) {
		Contact c=new Contact();
		c.setMailid(requestData.getMailid());
		c.setMoboleNo(requestData.getMoboleNo());
		c.setSecoundaryMobileNo(requestData.getSecoundaryMobileNo());
		c=contactRepository.save(c);
		ContactResponse cr=new ContactResponse();
		cr.setId(c.getId());
		cr.setMailid(c.getMailid());
		cr.setMoboleNo(c.getMoboleNo());
		cr.setSecoundaryMobileNo(c.getSecoundaryMobileNo());
		System.out.println(cr);
		return cr;
	}
	
	@Override
	public ContactResponse getContactById(Long id) {
		Contact contact = contactRepository.findById(id).get();
		ContactResponse c=new ContactResponse();
		c.setId(contact.getId());
		c.setMoboleNo(contact.getMoboleNo());
		c.setMailid(contact.getMailid());
		c.setSecoundaryMobileNo(contact.getSecoundaryMobileNo());
		return c;
	}

}
