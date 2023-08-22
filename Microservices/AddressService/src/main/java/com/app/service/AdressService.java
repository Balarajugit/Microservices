package com.app.service;

import com.app.request.AdressRequest;
import com.app.response.AdressResponse;

public interface AdressService {
	
	public AdressResponse createAdress(AdressRequest adReq);
	
	public AdressResponse getAdressById(Long id);

}
