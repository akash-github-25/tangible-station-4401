package com.masai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.

private Integer customerId;
private String customerName;
private String customerAddress;
private String customerMobile;
private String customerEmail;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
private List<Feedback> feedbacks = new ArrayList<>();


@OneToOne(cascade = CascadeType.MERGE,mappedBy = "custom")
private User user;


public Customer() {
	super();
	// TODO Auto-generated constructor stub
}


public Customer(Integer customerId, String customerName, String customerAddress, String customerMobile,
		String customerEmail, List<Feedback> feedbacks, User user) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerAddress = customerAddress;
	this.customerMobile = customerMobile;
	this.customerEmail = customerEmail;
	this.feedbacks = feedbacks;
	this.user = user;
}


public Integer getCustomerId() {
	return customerId;
}


public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}


public String getCustomerName() {
	return customerName;
}


public void setCustomerName(String customerName) {
	this.customerName = customerName;
}


public String getCustomerAddress() {
	return customerAddress;
}


public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}


public String getCustomerMobile() {
	return customerMobile;
}


public void setCustomerMobile(String customerMobile) {
	this.customerMobile = customerMobile;
}


public String getCustomerEmail() {
	return customerEmail;
}


public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}


public List<Feedback> getFeedbacks() {
	return feedbacks;
}


public void setFeedbacks(List<Feedback> feedbacks) {
	this.feedbacks = feedbacks;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}







}
