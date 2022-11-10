package com.masai.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class PayementDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.
  private Integer payementId;
  private String payementMethod;
  private LocalDate payementDate;
 
  @JsonIgnore
  @OneToOne
  private Booking booking;


public PayementDetails(Integer payementId, String payementMethod, LocalDate payementDate, Booking booking) {
	super();
	this.payementId = payementId;
	this.payementMethod = payementMethod;
	this.payementDate = payementDate;
	this.booking = booking;
}


public PayementDetails() {
	super();
	// TODO Auto-generated constructor stub
}


public Integer getPayementId() {
	return payementId;
}


public void setPayementId(Integer payementId) {
	this.payementId = payementId;
}


public String getPayementMethod() {
	return payementMethod;
}


public void setPayementMethod(String payementMethod) {
	this.payementMethod = payementMethod;
}


public LocalDate getPayementDate() {
	return payementDate;
}


public void setPayementDate(LocalDate payementDate) {
	this.payementDate = payementDate;
}


public Booking getBooking() {
	return booking;
}


public void setBooking(Booking booking) {
	this.booking = booking;
}

  
  
  
  
}
