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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.
	private Integer userId;
	private String userType;
	private String userPassword;
	
	@JsonIgnore
	@OneToOne
	private Customer custom;
	
	@JsonIgnore
	@OneToOne
	private Admin admin;
	
	@JsonIgnore
	@OneToOne
	private Travels travels;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Booking> Booking = new ArrayList<>();
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String userType, String userPassword) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userPassword = userPassword;
	}
	
	
	
}
