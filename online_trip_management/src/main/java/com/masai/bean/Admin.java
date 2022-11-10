package com.masai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.	
 private Integer adminId;
 private String adminName;
 private String adminEmail;
 private String adminMobile;
 
 @JsonIgnore
 @OneToMany(cascade = CascadeType.ALL,mappedBy = "admin")
 private List<Report> reports = new ArrayList<>();
 
 
 @OneToOne
 private User user;


public Admin(Integer adminId, String adminName, String adminEmail, String adminMobile, List<Report> reports,
		User user) {
	super();
	this.adminId = adminId;
	this.adminName = adminName;
	this.adminEmail = adminEmail;
	this.adminMobile = adminMobile;
	this.reports = reports;
	this.user = user;
}


public Admin() {
	super();
	// TODO Auto-generated constructor stub
}


public Integer getAdminId() {
	return adminId;
}


public void setAdminId(Integer adminId) {
	this.adminId = adminId;
}


public String getAdminName() {
	return adminName;
}


public void setAdminName(String adminName) {
	this.adminName = adminName;
}


public String getAdminEmail() {
	return adminEmail;
}


public void setAdminEmail(String adminEmail) {
	this.adminEmail = adminEmail;
}


public String getAdminMobile() {
	return adminMobile;
}


public void setAdminMobile(String adminMobile) {
	this.adminMobile = adminMobile;
}


public List<Report> getReports() {
	return reports;
}


public void setReports(List<Report> reports) {
	this.reports = reports;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}
 

 
}
