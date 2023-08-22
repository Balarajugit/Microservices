package com.app.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.entity.Adress;
import com.app.openfeign.ContactOpenfeign;
import com.app.repo.AdressRepository;
import com.app.request.AdressRequest;
import com.app.request.ContactRequest;
import com.app.response.AdressResponse;
import com.app.response.ContactResponse;

import reactor.core.publisher.Mono;

@Service
public class AdressServiceImpl implements AdressService {
	
	@Autowired
	public AdressRepository adRepo;
	
	@Autowired
	public WebClient webclient;
	
	@Autowired
	public ContactOpenfeign feign;
	
	@Override
	public AdressResponse createAdress(AdressRequest adReq) {
		//creating adress Object
		Adress a=new Adress();
		a.setVillage(adReq.getVillage());
		a.setMandal(adReq.getMandal());
		a.setDistict(adReq.getDistict());
		a.setState(adReq.getState());
		a.setPincode(adReq.getPincode());
		//getting the data from the contactService
		ContactResponse contactRes = creatContact(adReq.getContactData());
		
		a.setContact(contactRes.getId());
		a=adRepo.save(a);
		
		AdressResponse ar=new AdressResponse();
		ar.setId(a.getId());
		ar.setVillage(a.getVillage());
		ar.setMandal(a.getMandal());
		ar.setDistict(a.getDistict());
		ar.setState(a.getState());
		ar.setPincode(a.getPincode());
		ar.setContactresponse(contactRes);
		
		
		System.out.println("Getting Id"+ar.getContactresponse().getMailid());
		
		return ar;
	}
	
	public ContactResponse creatContact(ContactRequest c) {
		
		System.out.println("In Adress Service :: "+c.getSecoundaryMobileNo());
		//c=new ContactRequest();
		ContactResponse res=null;
		try {
			res=webclient.post()
			.uri("/saveContact")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.body(Mono.just(c), ContactRequest.class)
			.retrieve()
			.bodyToMono(ContactResponse.class)
			.block();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res);
		return res;
	}
	
	@Override
	public AdressResponse getAdressById(Long id) {
		Adress adress = adRepo.findById(id).get();
		AdressResponse ares=new AdressResponse();
		ares.setId(adress.getId());
		ares.setVillage(adress.getVillage());
		ares.setMandal(adress.getMandal());
		ares.setState(adress.getState());
		ares.setDistict(adress.getDistict());
		ares.setPincode(adress.getPincode());
	
		ares.setContactresponse(feign.getContactById(adress.getContact()));
		System.out.println("getting request ID ::"+adress.getContact());
		return ares;
	}
	
	/*
	 * public ContactResponse getContactById(Long id) { //c=new ContactRequest();
	 * ContactResponse res=null; try { feign.getContactById(id); } catch (Exception
	 * e) { // TODO: handle exception } return res; }
	 */

}
