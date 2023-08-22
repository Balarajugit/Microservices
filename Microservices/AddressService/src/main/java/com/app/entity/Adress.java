package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Adress")
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "village")
	private String village;
	@Column(name = "mandal")
	private String mandal;
	@Column(name = "distict")
	private String distict;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private Long pincode;
	@Column(name = "contact_Id")
	private Long contact_Id;
	
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
	public Long getContact() {
		return contact_Id;
	}
	public void setContact(Long contact_Id) {
		this.contact_Id = contact_Id;
	}
	@Override
	public String toString() {
		return "Adress [id=" + id + ", village=" + village + ", mandal=" + mandal + ", distict=" + distict + ", state="
				+ state + ", pincode=" + pincode + ", contact_Id=" + contact_Id + "]";
	}
	
	
	

}
