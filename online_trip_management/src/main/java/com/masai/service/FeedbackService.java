package com.masai.service;

import java.util.List;

import com.masai.bean.Customer;
import com.masai.bean.Feedback;
import com.masai.exception.CustomerException;
import com.masai.exception.FeedbackException;

public interface FeedbackService {
	
public Feedback addFeedback(Feedback feedback) throws FeedbackException;
public Feedback findByFeedbackId(Integer feedbackId) throws FeedbackException;
public List<Feedback> findByCustomerId(Integer customerId) throws FeedbackException,CustomerException;
public List<Feedback> viewAllFeedback() throws FeedbackException;


}
