package com.masai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Packages {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.
	private Integer packageId;
    private String packageName;
	private String packageDescription;
	
	@Enumerated(EnumType.ORDINAL)
	private PackageType packageType;
	
	private Integer packageCost;
	

	
	
@JsonIgnore
@ManyToOne
public Booking booking;
	
	
//	
	 @ManyToMany(cascade = CascadeType.ALL)
	 List<Hotel> hotels=new ArrayList<>();
	
	
	 @ManyToMany(cascade=CascadeType.ALL)
	 private List<Vehicle> vehicle=new ArrayList<>();


	public Packages(Integer packageId, String packageName, String packageDescription, PackageType packageType,
			Integer packageCost, Booking booking, List<Hotel> hotels, List<Vehicle> vehicle) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
		this.booking = booking;
		this.hotels = hotels;
		this.vehicle = vehicle;
	}


	public Packages() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getPackageId() {
		return packageId;
	}


	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public String getPackageDescription() {
		return packageDescription;
	}


	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}


	public PackageType getPackageType() {
		return packageType;
	}


	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
	}


	public Integer getPackageCost() {
		return packageCost;
	}


	public void setPackageCost(Integer packageCost) {
		this.packageCost = packageCost;
	}


	public Booking getBooking() {
		return booking;
	}


	public void setBooking(Booking booking) {
		this.booking = booking;
	}


	public List<Hotel> getHotels() {
		return hotels;
	}


	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}


	public List<Vehicle> getVehicle() {
		return vehicle;
	}


	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}


	

	
}
