package com.masai.bean;

import java.time.LocalDateTime;
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
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.	
private Integer routeId=0;
private Integer price;
private String startfrom;
private String destination;
private String arrival;
private String departure;
private Integer daysOfJourney;
private Integer vehicleId;

@JsonIgnore
@ManyToMany(cascade=CascadeType.ALL)
private List<Vehicle> vehicle=new ArrayList<>();



public Integer getVehicleId() {
	return vehicleId;
}



public void setVehicleId(Integer vehicleId) {
	this.vehicleId = vehicleId;
}



public Integer getRouteId() {
	return routeId;
}



public void setRouteId(Integer routeId) {
	this.routeId = routeId;
}



public Integer getPrice() {
	return price;
}



public void setPrice(Integer price) {
	this.price = price;
}



public String getStartfrom() {
	return startfrom;
}



public void setStartfrom(String startfrom) {
	this.startfrom = startfrom;
}



public String getDestination() {
	return destination;
}



public void setDestination(String destination) {
	this.destination = destination;
}



public String getArrival() {
	return arrival;
}



public void setArrival(String arrival) {
	this.arrival = arrival;
}



public String getDeparture() {
	return departure;
}



public void setDeparture(String departure) {
	this.departure = departure;
}



public Integer getDaysOfJourney() {
	return daysOfJourney;
}



public void setDaysOfJourney(Integer daysOfJourney) {
	this.daysOfJourney = daysOfJourney;
}



public List<Vehicle> getVehicle() {
	return vehicle;
}



public void setVehicle(List<Vehicle> vehicle) {
	this.vehicle = vehicle;
}



public Route() {
	super();
//	arrival=LocalDateTime.now();
//	departure=LocalDateTime.now();
	// TODO Auto-generated constructor stub
}



public Route(Integer routeId, Integer price, String startfrom, String destination, String arrival,
		String departure, Integer daysOfJourney, List<Vehicle> vehicle) {
	super();
	this.routeId = routeId;
	this.price = price;
	this.startfrom = startfrom;
	this.destination = destination;
	this.arrival = arrival;
	this.departure = departure;
	this.daysOfJourney = daysOfJourney;
	this.vehicle = vehicle;
}



}
