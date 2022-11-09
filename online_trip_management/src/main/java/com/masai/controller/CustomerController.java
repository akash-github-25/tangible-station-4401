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
import com.masai.exception.CustomerException;
import com.masai.repository.CustomerRepo;
import com.masai.service.CustomerService;
@RestController
public class CustomerController {
	@Autowired
	public CustomerService cs;
	
	@Autowired
	public CustomerRepo cr;

	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) throws CustomerException {
		cs.addCustomer(customer);
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException{
		Customer custom=cs.updateCustomer(customer);
		return new ResponseEntity<Customer>(custom,HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
		Customer custom=cs.deleteCustomer(cr.findById(customerId).get());
		return new ResponseEntity<Customer>(custom,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomer/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
		Customer custom=cs.viewCustomer(customerId);
		return new ResponseEntity<Customer>(custom,HttpStatus.OK);
}
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> viewAllCustomer() throws CustomerException{
		List<Customer> custom=cs.viewAllCustomer();
		return new ResponseEntity<List<Customer>>(custom,HttpStatus.OK);
	}
}
