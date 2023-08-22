package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "moboleNo")
	private String moboleNo;
	@Column(name = "mailid")
	private String mailid;
	@Column(name = "secoundaryMobileNo")
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
		return "Contact [id=" + id + ", moboleNo=" + moboleNo + ", mailid=" + mailid + ", secoundaryMobileNo="
				+ secoundaryMobileNo + "]";
	}

	
}
