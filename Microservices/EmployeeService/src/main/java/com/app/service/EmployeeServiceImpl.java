package com.app.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.entity.Employee;
import com.app.feignclient.AdressFeignClient;
import com.app.repo.EmployeeRepository;
import com.app.req.AdressRequest;
import com.app.req.EmployeeRequest;
import com.app.respponse.AdressResponse;
import com.app.respponse.ContactResponse;
import com.app.respponse.EmployeeResponse;
import com.fasterxml.jackson.databind.util.JSONPObject;

import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	WebClient webclient;
	@Autowired
	AdressFeignClient adressData;

	@Override
	public EmployeeResponse createEmployee(EmployeeRequest empReq) {
		Employee e = new Employee();
		e.setName(empReq.getName());
		e.setDepartment(empReq.getDepartment());
		e.setPrfession(empReq.getPrfession());
		e.setJoinDate(empReq.getJoinDate());
		e.setSalarie(empReq.getSalarie());
		//AdressResponse adressResponse = creatAdress(empReq.getAdrequest());
		
		//AdressResponse adressResponse =adressData.createAdress(empReq.getAdrequest());
		
		AdressResponse adressResponse = gettingData(empReq.getAdrequest());

		e.setAddress(adressResponse.getId());

		e = empRepo.save(e);

		EmployeeResponse er = new EmployeeResponse();
		er.setId(e.getId());
		er.setName(e.getName());
		er.setDepartment(e.getDepartment());
		er.setPrfession(e.getPrfession());
		er.setJoinDate(e.getJoinDate());
		er.setSalarie(e.getSalarie());
		er.setAdress(adressResponse);

		return er;
	}
	
	
	
	  public AdressResponse gettingData(AdressRequest adRequest) {
	  
		 System.out.println("getting adressRequest :: "+adRequest.getPincode());
		 System.out.println("getting adressRequest :: "+adRequest.getContactData().getMoboleNo());
	  AdressResponse a = null; 
	  String data=adressData.createAdress(adRequest); 
	  try
	  { 
		  JSONObject jc = new JSONObject(data);
	  
	  
	  Integer i = new Integer(jc.getInt("id"));
	  Long aid = i.longValue();
	  
	  String avillage=(String)jc.get("village"); 
	  String amandal=(String)jc.get("mandal"); 
	  String adistict=(String)jc.get("distict");
	  String astate=(String)jc.get("state"); 
	  Integer i2= new Integer(jc.getInt("pincode")); 
	  Long apincode = i2.longValue();
	  System.out.println("pincode :: "+apincode); 
	  JSONObject cj =jc.getJSONObject("contactresponse");
	  
	  Integer i1 = new Integer(cj.getInt("id")); Long cid = i1.longValue(); String
	  cmoboleNo=(String)cj.get("moboleNo"); String
	  cmailid=(String)cj.get("mailid"); String
	  csecoundaryMobileNo=(String)cj.get("secoundaryMobileNo");
	  
	  ContactResponse c=new ContactResponse(); c.setId(cid);
	  c.setMoboleNo(cmoboleNo); c.setMailid(cmailid);
	  c.setSecoundaryMobileNo(csecoundaryMobileNo);
	  
	  a=new AdressResponse(); a.setId(aid); a.setVillage(avillage);
	  a.setMandal(amandal); a.setPincode(apincode); 
	  //a.setMandal(amandal);
	  a.setDistict(adistict);
	  a.setState(astate);
	  a.setContact(c); 
	  } catch (Exception e) { 
		  // TODO Auto-generated catch block e.printStackTrace(); 
		  
	  }
	  return a;
	  
	  
	  }
	  
	  
	  @Override
	public EmployeeResponse getEmployeeById(Long id) {
		Employee employee = empRepo.findById(id).get();
		EmployeeResponse emp=new EmployeeResponse();
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		emp.setDepartment(employee.getDepartment());
		emp.setJoinDate(employee.getJoinDate());
		emp.setPrfession(employee.getPrfession());
		emp.setSalarie(employee.getSalarie());
		emp.setAdress(getAdressById(employee.getAddress()));
		System.out.println("getting adress id :: "+employee.getAddress());
		return emp;
	}
	  
	  public AdressResponse getAdressById(Long id) {
		  AdressResponse a = null; 
		  try { String data =adressData.getAdressById(id);
		  
				  JSONObject jc = new JSONObject(data);
				  
				  
				  Integer i = new Integer(jc.getInt("id")); Long aid = i.longValue();
				  
				  String avillage=(String)jc.get("village"); String
				  amandal=(String)jc.get("mandal"); String adistict=(String)jc.get("distict");
				  String astate=(String)jc.get("state"); Integer i2= new
				  Integer(jc.getInt("pincode")); Long apincode = i2.longValue();
				  System.out.println("pincode :: "+apincode); JSONObject cj =
				  jc.getJSONObject("contactresponse");
				  
				  Integer i1 = new Integer(cj.getInt("id")); Long cid = i1.longValue(); String
				  cmoboleNo=(String)cj.get("moboleNo"); String
				  cmailid=(String)cj.get("mailid"); String
				  csecoundaryMobileNo=(String)cj.get("secoundaryMobileNo");
				  
				  ContactResponse c=new ContactResponse(); c.setId(cid);
				  c.setMoboleNo(cmoboleNo); c.setMailid(cmailid);
				  c.setSecoundaryMobileNo(csecoundaryMobileNo);
				  
				  a=new AdressResponse();
				  a.setId(aid);
				  a.setVillage(avillage);
				  a.setMandal(amandal); 
				  a.setPincode(apincode); //a.setMandal(amandal);
				  a.setDistict(adistict); 
				  a.setState(astate); 
				  a.setContact(c);
		  } catch (Exception e) { // TODO Auto-generated catch block
			  e.printStackTrace(); }
		  return a; 
	  }
	  
	  public AdressResponse creatAdress(AdressRequest adRequest) {
	  
	  AdressResponse a = null; try { String data = webclient.post()
	  .uri("/createAdress") .contentType(MediaType.APPLICATION_JSON)
	  .accept(MediaType.APPLICATION_JSON) .body(Mono.just(adRequest),
	  AdressRequest.class) .retrieve() .bodyToMono(String.class) .block();
	  JSONObject jc = new JSONObject(data);
	  
	  
	  Integer i = new Integer(jc.getInt("id")); Long aid = i.longValue();
	  
	  String avillage=(String)jc.get("village"); String
	  amandal=(String)jc.get("mandal"); String adistict=(String)jc.get("distict");
	  String astate=(String)jc.get("state"); Integer i2= new
	  Integer(jc.getInt("pincode")); Long apincode = i2.longValue();
	  System.out.println("pincode :: "+apincode); JSONObject cj =
	  jc.getJSONObject("contactresponse");
	  
	  Integer i1 = new Integer(cj.getInt("id")); Long cid = i1.longValue(); String
	  cmoboleNo=(String)cj.get("moboleNo"); String
	  cmailid=(String)cj.get("mailid"); String
	  csecoundaryMobileNo=(String)cj.get("secoundaryMobileNo");
	  
	  ContactResponse c=new ContactResponse(); c.setId(cid);
	  c.setMoboleNo(cmoboleNo); c.setMailid(cmailid);
	  c.setSecoundaryMobileNo(csecoundaryMobileNo);
	  
	  a=new AdressResponse(); a.setId(aid); a.setVillage(avillage);
	  a.setMandal(amandal); a.setPincode(apincode); //a.setMandal(amandal);
	  a.setDistict(adistict); a.setState(astate); a.setContact(c);
	  
	  
	  
	  
	  
	  } catch (Exception e) { // TODO Auto-generated catch block
	  e.printStackTrace(); }
	  
	  
	  return a; }
	 

}
