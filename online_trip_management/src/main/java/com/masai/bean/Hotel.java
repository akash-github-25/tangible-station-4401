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
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.
	private Integer hotelId;
	private String hotelName;
	private String hotelType;
	private String hotelDescription;
	private String hotelAddress;
	private Integer hotelRent;
	private String hotelStatus;
	private Integer hotelRooms;
	
	@JsonIgnore
	@ManyToOne
	private Booking book;
	
	 @ManyToMany(cascade = CascadeType.ALL,mappedBy = "hotels")
		public List<Packages> packages=new ArrayList<>();

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(Integer hotelId, String hotelName, String hotelType, String hotelDescription, String hotelAddress,
			Integer hotelRent, String hotelStatus, Integer hotelRooms, Booking book, List<Packages> packages) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.hotelAddress = hotelAddress;
		this.hotelRent = hotelRent;
		this.hotelStatus = hotelStatus;
		this.hotelRooms = hotelRooms;
		this.book = book;
		this.packages = packages;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public Integer getHotelRent() {
		return hotelRent;
	}

	public void setHotelRent(Integer hotelRent) {
		this.hotelRent = hotelRent;
	}

	public String getHotelStatus() {
		return hotelStatus;
	}

	public void setHotelStatus(String hotelStatus) {
		this.hotelStatus = hotelStatus;
	}

	public Integer getHotelRooms() {
		return hotelRooms;
	}

	public void setHotelRooms(Integer hotelRooms) {
		this.hotelRooms = hotelRooms;
	}

	public Booking getBook() {
		return book;
	}

	public void setBook(Booking book) {
		this.book = book;
	}

	public List<Packages> getPackages() {
		return packages;
	}

	public void setPackages(List<Packages> packages) {
		this.packages = packages;
	}

	

}
