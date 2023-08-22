package com.app.response;

public class ContactResponse {
	
	private Long id;
	private String moboleNo;
	private String mailid;
	private String secoundaryMobileNo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
		return "ContactResponse [id=" + id + ", moboleNo=" + moboleNo + ", mailid=" + mailid + ", secoundaryMobileNo="
				+ secoundaryMobileNo + "]";
	}
	
	

}
