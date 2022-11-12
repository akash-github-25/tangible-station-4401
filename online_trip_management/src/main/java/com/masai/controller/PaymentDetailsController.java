package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Hotel;
import com.masai.bean.PayementDetails;
import com.masai.exception.HotelException;
import com.masai.exception.PaymentsDetailsException;
import com.masai.service.payment.PaymentService;

@RestController
public class PaymentDetailsController {
	@Autowired
public PaymentService ps;
	@PostMapping("/payment")
	public ResponseEntity<PayementDetails> saveCustomer(@RequestBody PayementDetails payment) throws  PaymentsDetailsException {
		ps.addPayement(payment);
		return new ResponseEntity<>(payment,HttpStatus.CREATED);
	}
}
