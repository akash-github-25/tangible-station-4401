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
	
	private String feedback;
	private Integer rating;
	private LocalDate submitDate;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "custom_id", referencedColumnName = "customerId")
	public Customer customer;
	
	

	public Feedback() {
		super();
		submitDate=LocalDate.now();
		// TODO Auto-generated constructor stub
	}



	public Feedback(String feedback, Integer rating, Customer customer) {
		super();
		this.feedback = feedback;
		this.rating = rating;
		this.customer = customer;
	}





	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}


	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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
