package com.app.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.response.ContactResponse;

/*@FeignClient(url = "${contact.service.urlfeign}",value = "contact-feign-client",path = "/api/contact")*/
@FeignClient(value="Contact-Service", path = "/api/contact")
public interface ContactOpenfeign {
	
	@GetMapping("/get/{id}")
	public ContactResponse getContactById(@PathVariable Long id);

}
