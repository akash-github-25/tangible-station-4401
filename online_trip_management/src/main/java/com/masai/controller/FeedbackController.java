package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Customer;
import com.masai.bean.Feedback;
import com.masai.exception.CustomerException;
import com.masai.exception.FeedbackException;
import com.masai.service.CustomerService;
import com.masai.service.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	public FeedbackService fs;
	@Autowired
	public CustomerService cs;

	@PostMapping("/feedback")
	public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) throws CustomerException, FeedbackException {
//		Customer custom=feedback.getCustomer();
//		cs.addCustomer(custom);
		Feedback f=fs.addFeedback(feedback);
		return new ResponseEntity<Feedback>(f,HttpStatus.CREATED);
	}
	
	@GetMapping("/getFeedbackbyfeedbackId/{feedbackId}")
	public ResponseEntity<Feedback> viewFeedbackbyFeedbackId(@PathVariable("feedbackId") Integer feedbackId) throws CustomerException, FeedbackException{
		Feedback feed=fs.findByFeedbackId(feedbackId);
		return new ResponseEntity<Feedback>(feed,HttpStatus.OK);
}
	@GetMapping("/getFeedbackbycustomerId/{customerId}")
	public ResponseEntity<List<Feedback>> viewFeedbackbyCustomerId(@PathVariable("customerId") Integer customerId) throws CustomerException, FeedbackException{
		List<Feedback> feed=fs.findByCustomerId(customerId);
		return new ResponseEntity<List<Feedback>>(feed,HttpStatus.OK);
}
	
	@GetMapping("/getAllFeedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedback() throws FeedbackException{
		List<Feedback> feed=fs.viewAllFeedback();
		return new ResponseEntity<List<Feedback>>(feed,HttpStatus.OK);
	}

}
