package com.app.request;

import org.springframework.stereotype.Component;

@Component
public class AdressRequest {
	
	private String village;
	private String mandal;
	private String distict;
	private String state;
	private Long pincode;
	
	private ContactRequest contactData=new ContactRequest();

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

	public ContactRequest getContactData() {
		return contactData;
	}

	public void setContactData(ContactRequest contactData) {
		this.contactData = contactData;
	}

	@Override
	public String toString() {
		return "AdressRequest [village=" + village + ", mandal=" + mandal + ", distict=" + distict + ", state=" + state
				+ ", pincode=" + pincode + ", contactData=" + contactData + "]";
	}
	
	
	
	
	
	
	

}
