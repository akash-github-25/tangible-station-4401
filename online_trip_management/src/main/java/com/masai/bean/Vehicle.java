package com.masai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.	
 private Integer vehicleId;
 private String vehicleReg;
 private String vehicleType;
 private Integer seats;
 private String  cooling;
 private Integer travelsId;
 
 public Integer getTravelsId() {
	return travelsId;
}

public void setTravelsId(Integer travelsId) {
	this.travelsId = travelsId;
}
@JsonIgnore
@ManyToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "veh_id", referencedColumnName = "travelsId")
 public Travels travels;
 
// @JsonIgnore
 @ManyToMany(cascade = CascadeType.ALL,mappedBy = "vehicle")
 private List<Route> routes=new ArrayList<>();
 
 
 
 @JsonIgnore
	@OneToMany
//	@JoinColumn(name = "bookingid", referencedColumnName = "vehicleId")
	private List<Booking> book=new ArrayList<>();
 
 @JsonIgnore
 @ManyToMany
 private List<Packages> packages=new ArrayList<>();

public Vehicle(Integer vehicleId, String vehicleReg, String vehicleType, Integer seats, String cooling,
		Integer travelsId, Travels travels, List<Route> routes, List<Booking> book, List<Packages> packages) {
	super();
	this.vehicleId = vehicleId;
	this.vehicleReg = vehicleReg;
	this.vehicleType = vehicleType;
	this.seats = seats;
	this.cooling = cooling;
	this.travelsId = travelsId;
	this.travels = travels;
	this.routes = routes;
	this.book = book;
	this.packages = packages;
}

public Vehicle() {
	super();
	// TODO Auto-generated constructor stub
}

public Integer getVehicleId() {
	return vehicleId;
}

public void setVehicleId(Integer vehicleId) {
	this.vehicleId = vehicleId;
}

public String getVehicleReg() {
	return vehicleReg;
}

public void setVehicleReg(String vehicleReg) {
	this.vehicleReg = vehicleReg;
}

public String getVehicleType() {
	return vehicleType;
}

public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}

public Integer getSeats() {
	return seats;
}

public void setSeats(Integer seats) {
	this.seats = seats;
}

public String getCooling() {
	return cooling;
}

public void setColling(String cooling) {
	this.cooling = cooling;
}

public Travels getTravels() {
	return travels;
}

public void setTravels(Travels travels) {
	this.travels = travels;
}

public List<Route> getRoutes() {
	return routes;
}

public void setRoutes(List<Route> routes) {
	this.routes = routes;
}

public List<Booking> getBook() {
	return book;
}

public void setBook(List<Booking> book) {
	this.book = book;
}

public List<Packages> getPackages() {
	return packages;
}

public void setPackages(List<Packages> packages) {
	this.packages = packages;
}


 
	
}
