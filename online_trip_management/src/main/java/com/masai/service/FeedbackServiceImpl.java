package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Customer;
import com.masai.bean.Feedback;
import com.masai.exception.CustomerException;
import com.masai.exception.FeedbackException;
import com.masai.repository.CustomerRepo;
import com.masai.repository.FeedbackRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	@Autowired
    public FeedbackRepo fr;
	
	@Autowired
	public CustomerRepo cr;
	
	@Override
	public Feedback addFeedback(Feedback feedback) throws FeedbackException {
//		// TODO Auto-generated method stub
//		Customer c=feedback.getCustomer();
//		List<Feedback> v=c.getFeedbacks();
//		v.add(feedback);
//		cr.save(c);
		Feedback fb=fr.save(feedback);
		if(fb!=null) {
			return fb;
		}else {
			throw new FeedbackException("Feedback can't be added");
		}
		
	}

	@Override
	public Feedback findByFeedbackId(Integer feedbackId) throws FeedbackException {
		// TODO Auto-generated method stub
		Optional<Feedback> feed=fr.findById(feedbackId);
		if(feed!=null) {
			return feed.get();
		}else {
			throw new FeedbackException("feedbackId not added");
		}
		
	}

	@Override
	public List<Feedback> findByCustomerId(Integer customerId) throws FeedbackException, CustomerException {
		// TODO Auto-generated method stub
		List<Feedback> d=fr.viewFeedbackByCustomerId(customerId);
		if(d.size()!=0) {
			return d;
		}else {
			throw new FeedbackException("No feedback present with this customerId");
		}
		
	}

	@Override
	public List<Feedback> viewAllFeedback() throws FeedbackException {
		// TODO Auto-generated method stub
		List<Feedback> feed=fr.findAll();
		if(feed.size()!=0) {
			return feed;
		}else {
			throw new FeedbackException("No feedback is there");
		}
		
	}

}
