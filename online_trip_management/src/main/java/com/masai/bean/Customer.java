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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.

private Integer customerId;
private String customerName;
private String customerPassword;
private String address;
private String mobileNo;
private String email;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
private List<Feedback> feedbacks = new ArrayList<>();


	public Customer(Integer customerId, String customerName, String customerPassword, String address, String mobileNo,
		String email, List<Feedback> feedbacks) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerPassword = customerPassword;
	this.address = address;
	this.mobileNo = mobileNo;
	this.email = email;
	this.feedbacks = feedbacks;
}


	public Customer() {
		super();
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


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}


	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
