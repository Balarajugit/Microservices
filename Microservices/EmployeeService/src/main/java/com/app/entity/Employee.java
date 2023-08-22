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
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name ="department")
	private String department;
	@Column(name ="prfession")
	private String prfession;
	@Column(name ="joinDate")
	private String joinDate;
	@Column(name ="salarie")
	private String salarie;
	
	@Column(name = "address_Id")
	//@Column(name ="address")
	private Long address_Id;
	
	

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
	public Long getAddress() {
		return address_Id;
	}
	public void setAddress(Long address_Id) {
		this.address_Id = address_Id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", prfession=" + prfession
				+ ", joinDate=" + joinDate + ", salarie=" + salarie + ", address_Id=" + address_Id + "]";
	}
	
	
	
	

}
