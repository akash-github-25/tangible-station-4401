package com.masai.bean;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.
	private Integer feedbackId;
	private String description;
	private Integer rating;
	private LocalDate submitDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custom_id", referencedColumnName = "customerId")
	public Customer customer;
	
	

	public Feedback() {
		super();
		submitDate=LocalDate.now();
		// TODO Auto-generated constructor stub
	}



	public Feedback(Integer feedbackId, String description, Integer rating, LocalDate submitDate, Customer customer) {
		super();
		this.feedbackId = feedbackId;
		this.description = description;
		this.rating = rating;
		this.submitDate = submitDate;
		this.customer = customer;
	}


	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public LocalDate getSubmitDate() {
		return submitDate;
	}



	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



}
