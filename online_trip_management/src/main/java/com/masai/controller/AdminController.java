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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Admin;
import com.masai.bean.Customer;
import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.repository.CustomerRepo;
import com.masai.service.admin.AdminService;
import com.masai.service.customer.CustomerService;
@RestController
public class AdminController {

//	@Autowired
//	public CustomerService cs;
	
	@Autowired
	public CustomerRepo cr;
	
	@Autowired
	public AdminService as;

	@PostMapping("/customerAdmin")
	public ResponseEntity<Customer> saveCustomerAdmin(@RequestBody Customer customer) throws CustomerException {
		as.addCustomer(customer);
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}
//	
	@PutMapping("/updateCustomerAdmin")
	public ResponseEntity<Customer> updateCustomerAdmin(@RequestBody Customer customer) throws CustomerException{
		Customer custom=as.updateCustomer(customer);
		return new ResponseEntity<Customer>(custom,HttpStatus.ACCEPTED);	
	}
//	
	@DeleteMapping("/deleteCustomerAdmin/{customerId}")
	public ResponseEntity<Customer> deleteCustomerAdmin(@PathVariable("customerId") Integer customerId) throws CustomerException{
		Customer custom=as.deleteCustomer(cr.findById(customerId).get());
		return new ResponseEntity<Customer>(custom,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerAdmin/{customerId}")
	public ResponseEntity<Customer> viewCustomerAdmin(@PathVariable("customerId") Integer customerId) throws CustomerException{
		Customer custom=as.viewCustomer(customerId);
		return new ResponseEntity<Customer>(custom,HttpStatus.OK);
}
	@PostMapping("/admin")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) throws AdminException{
		Admin adminAdded=as.addAdmin(admin);
		return new ResponseEntity<Admin>(adminAdded,HttpStatus.CREATED);
	}
	@GetMapping("/viewAllCustomerAdmin")
	public ResponseEntity<List<Customer>> viewAllCustomerAdmin(@RequestParam("key") String key) throws CustomerException{
		List<Customer> custom=as.viewAllCustomer(key);
		 return new ResponseEntity<List<Customer>>(custom,HttpStatus.OK);	
		
	}

}
