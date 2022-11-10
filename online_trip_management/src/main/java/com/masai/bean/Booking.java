package com.masai.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.
	private Integer bookingId;
	private String bookingType;
	private String description;
	private String bookingTitle;
	private LocalDate bookingDate;
	


	@OneToOne(cascade=CascadeType.ALL)
	private PayementDetails payement;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	public User user;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "book")
	private List<Hotel> hotels=new ArrayList<>();

   @OneToMany(cascade=CascadeType.ALL)
 private List<Packages> packages=new ArrayList<>();
	
	@OneToMany
//	@JoinColumn(name = "bookingid", referencedColumnName = "vehicleId")
	private List<Vehicle> vehicle=new ArrayList<>();

	public Booking(Integer bookingId, String bookingType, String description, String bookingTitle,
			LocalDate bookingDate, PayementDetails payement, User user, List<Hotel> hotels, List<Packages> packages,
			List<Vehicle> vehicle) {
		super();
		this.bookingId = bookingId;
		this.bookingType = bookingType;
		this.description = description;
		this.bookingTitle = bookingTitle;
		this.bookingDate = bookingDate;
		this.payement = payement;
		this.user = user;
		this.hotels = hotels;
		this.packages = packages;
		this.vehicle = vehicle;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public PayementDetails getPayement() {
		return payement;
	}

	public void setPayement(PayementDetails payement) {
		this.payement = payement;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Packages> getPackages() {
		return packages;
	}

	public void setPackages(List<Packages> packages) {
		this.packages = packages;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}




}
