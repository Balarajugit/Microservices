package com.app.request;

import org.springframework.stereotype.Component;

@Component
public class ContactRequest {
	
	private String moboleNo;
	private String mailid;
	private String secoundaryMobileNo;
	
	public String getMoboleNo() {
		return moboleNo;
	}
	public void setMoboleNo(String moboleNo) {
		this.moboleNo = moboleNo;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getSecoundaryMobileNo() {
		return secoundaryMobileNo;
	}
	public void setSecoundaryMobileNo(String secoundaryMobileNo) {
		this.secoundaryMobileNo = secoundaryMobileNo;
	}
	@Override
	public String toString() {
		return "ContactRequest [moboleNo=" + moboleNo + ", mailid=" + mailid + ", secoundaryMobileNo="
				+ secoundaryMobileNo + "]";
	}
	
	

}
