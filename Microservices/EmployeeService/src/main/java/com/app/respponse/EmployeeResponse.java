package com.app.respponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.req.AdressRequest;

public class EmployeeResponse {
	
	private Long id;
	private String name;
	private String department;
	private String prfession;
	private String joinDate;
	private String salarie;
	
	private AdressResponse adress;
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPrfession() {
		return prfession;
	}

	public void setPrfession(String prfession) {
		this.prfession = prfession;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getSalarie() {
		return salarie;
	}

	public void setSalarie(String salarie) {
		this.salarie = salarie;
	}

	public AdressResponse getAdress() {
		return adress;
	}

	public void setAdress(AdressResponse adress) {
		this.adress = adress;
	}

	

	


}
