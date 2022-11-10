package com.masai.bean;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.	
private Integer routeId;
private Integer price;
private String startfrom;
private String destination;
private LocalDateTime arrival;
private LocalDateTime departure;
private Integer daysOfJourney;

@ManyToMany(cascade=CascadeType.ALL,mappedBy = "seats")
private List<Vehicle> vehicle;



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



public LocalDateTime getArrival() {
	return arrival;
}



public void setArrival(LocalDateTime arrival) {
	this.arrival = arrival;
}



public LocalDateTime getDeparture() {
	return departure;
}



public void setDeparture(LocalDateTime departure) {
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
	// TODO Auto-generated constructor stub
}



public Route(Integer routeId, Integer price, String startfrom, String destination, LocalDateTime arrival,
		LocalDateTime departure, Integer daysOfJourney, List<Vehicle> vehicle) {
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
