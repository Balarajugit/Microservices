package com.app.response;

import javax.persistence.Column;

import com.app.entity.Adress;

public class AdressResponse {
	
	private Long id;
	private String village;
	private String mandal;
	private String distict;
	private String state;
	private Long pincode;
	private ContactResponse contactresponse=new ContactResponse();
	
	public AdressResponse() {
		super();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getDistict() {
		return distict;
	}
	public void setDistict(String distict) {
		this.distict = distict;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public ContactResponse getContactresponse() {
		return contactresponse;
	}
	public void setContactresponse(ContactResponse contactresponse) {
		this.contactresponse = contactresponse;
	}
	@Override
	public String toString() {
		return "AdressResponse [id=" + id + ", village=" + village + ", mandal=" + mandal + ", distict=" + distict
				+ ", state=" + state + ", pincode=" + pincode + ", contactresponse=" + contactresponse + "]";
	}
	
	
	

}
