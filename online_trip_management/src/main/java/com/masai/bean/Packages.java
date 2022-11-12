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
	
	
	private Integer packageType;
	
	private Integer packageCost;
	private Integer hotelId;
	private Integer VehicleId;
	
	

	@JsonIgnore
	   @OneToMany(cascade=CascadeType.ALL)
	 private List<Booking> book=new ArrayList<>();	
	

	
	
     @JsonIgnore
	 @ManyToMany(cascade = CascadeType.ALL)
	 List<Hotel> hotels=new ArrayList<>();
	
	  @JsonIgnore
	 @ManyToMany(cascade=CascadeType.ALL,mappedBy = "vehicleReg")
	 private List<Vehicle> vehicle=new ArrayList<>();

	public Packages(Integer packageId, String packageName, String packageDescription, Integer packageType,
			Integer packageCost, Integer hotelId, Integer vehicleId, List<Booking> book, List<Hotel> hotels,
			List<Vehicle> vehicle) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
		this.hotelId = hotelId;
		VehicleId = vehicleId;
		this.book = book;
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

	public Integer getPackageType() {
		return packageType;
	}

	public void setPackageType(Integer packageType) {
		this.packageType = packageType;
	}

	public Integer getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(Integer packageCost) {
		this.packageCost = packageCost;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getVehicleId() {
		return VehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		VehicleId = vehicleId;
	}

	public List<Booking> getBook() {
		return book;
	}

	public void setBook(List<Booking> book) {
		this.book = book;
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
