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
public class Travels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.	
 private Integer travelsId;
 private String travelsName;
 private String travelsEmail;
 private String travelsContact;
 private String travelsAddress;
 
// @JsonIgnore
// @OneToMany(cascade = CascadeType.ALL,mappedBy = "Travel")
// private List<Vehicle> vehicle = new ArrayList<>();
 
	@JsonIgnore
	@OneToOne
	private User user;

	public Travels(Integer travelsId, String travelsName, String travelsEmail, String travelsContact,
			String travelsAddress, List<Vehicle> vehicle, User user) {
		super();
		this.travelsId = travelsId;
		this.travelsName = travelsName;
		this.travelsEmail = travelsEmail;
		this.travelsContact = travelsContact;
		this.travelsAddress = travelsAddress;
//		this.vehicle = vehicle;
		this.user = user;
	}

	public Travels() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTravelsId() {
		return travelsId;
	}

	public void setTravelsId(Integer travelsId) {
		this.travelsId = travelsId;
	}

	public String getTravelsName() {
		return travelsName;
	}

	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}

	public String getTravelsEmail() {
		return travelsEmail;
	}

	public void setTravelsEmail(String travelsEmail) {
		this.travelsEmail = travelsEmail;
	}

	public String getTravelsContact() {
		return travelsContact;
	}

	public void setTravelsContact(String travelsContact) {
		this.travelsContact = travelsContact;
	}

	public String getTravelsAddress() {
		return travelsAddress;
	}

	public void setTravelsAddress(String travelsAddress) {
		this.travelsAddress = travelsAddress;
	}

//	public List<Vehicle> getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(List<Vehicle> vehicle) {
//		this.vehicle = vehicle;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
