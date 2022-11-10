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

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.	
 private Integer vehicleId;
 private String vehicleReg;
 private String vehicleType;
 private Integer seats;
 private String  colling;
 
// @ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "vehicle1_Id", referencedColumnName = "travelsId")
//	public Travels travels;
 
 @JsonIgnore
 @ManyToMany
 private List<Route> routes=new ArrayList<>();
 
 @JsonIgnore
 @ManyToOne(cascade = CascadeType.ALL)
  public Booking booking;
 
// @JsonIgnore
// @ManyToMany(cascade=CascadeType.ALL,mappedBy = "vehicle")
// private List<Package> packages=new ArrayList<>();

public Vehicle(Integer vehicleId, String vehicleReg, String vehicleType, Integer seats, String colling, Travels travels,
		List<Route> routes, Booking booking, List<Package> packages) {
	super();
	this.vehicleId = vehicleId;
	this.vehicleReg = vehicleReg;
	this.vehicleType = vehicleType;
	this.seats = seats;
	this.colling = colling;
//	this.travels = travels;
	this.routes = routes;
	this.booking = booking;
//	this.packages = packages;
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

public String getColling() {
	return colling;
}

public void setColling(String colling) {
	this.colling = colling;
}

//public Travels getTravels() {
//	return travels;
//}
//
//public void setTravels(Travels travels) {
//	this.travels = travels;
//}

public List<Route> getRoutes() {
	return routes;
}

public void setRoutes(List<Route> routes) {
	this.routes = routes;
}

public Booking getBooking() {
	return booking;
}

public void setBooking(Booking booking) {
	this.booking = booking;
}

//public List<Package> getPackages() {
//	return packages;
//}
//
//public void setPackages(List<Package> packages) {
//	this.packages = packages;
//}
 
 
 
 
 
	
}
