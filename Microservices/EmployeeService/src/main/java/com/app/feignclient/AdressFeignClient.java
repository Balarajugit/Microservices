package com.app.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.req.AdressRequest;
import com.app.respponse.AdressResponse;



/*@FeignClient(url = "${adress.service.urlfeign}",value = "adress-feign-client",path = "/api/adress")*/
/*@FeignClient(value="Adress-Service",path ="/api/adress" )*/
@FeignClient(value="api-gateway",path = "/adress-service/api/adress")
public interface AdressFeignClient {
	
	@PostMapping("/createAdress")
	public String createAdress(@RequestBody AdressRequest a);
	
	@GetMapping("/getAdress/{id}")
	public String getAdressById(@PathVariable Long id);

}
