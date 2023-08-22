package com.app.req;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRequest {
	
	private String name;
	private String department;
	private String prfession;
	private String joinDate;
	private String salarie;
	@Autowired
	private AdressRequest adrequest;

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

	public AdressRequest getAdrequest() {
		return adrequest;
	}

	public void setAdrequest(AdressRequest adrequest) {
		this.adrequest = adrequest;
	}

	
}
