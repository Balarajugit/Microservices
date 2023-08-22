package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.request.AdressRequest;
import com.app.response.AdressResponse;
import com.app.service.AdressService;

@RestController
@RequestMapping("/api/adress")
public class AdressController {
	
	
	@Autowired
	AdressService adService;
	
	
	@PostMapping("/createAdress")
	public AdressResponse createAdress(@RequestBody AdressRequest a) {
		AdressResponse response = adService.createAdress(a);
		System.out.println(response.getContactresponse().getMoboleNo());
		return response;
	}
	
	@GetMapping("/getAdress/{id}")
	public AdressResponse getAdressById(@PathVariable Long id) {
		
		return adService.getAdressById(id);
	}

}
