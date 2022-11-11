package com.masai.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Admin;
import com.masai.bean.Customer;
import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.repository.AdminRepo;
import com.masai.repository.CustomerRepo;
@Service
public class AdminServiceImpl implements AdminService{

	  @Autowired
		public CustomerRepo cr;
	  
	  @Autowired
	  public AdminRepo ar;
	    
		@Override
		public Customer addCustomer(Customer customer) throws CustomerException {
			// TODO Auto-generated method stub
			
			Customer customerSaved=cr.save(customer);
			if(customerSaved!=null) {
				return customerSaved;
			}else {
				throw new CustomerException("Customer cannot be added");
			}
			
		}

		@Override
		public Customer updateCustomer(Customer customer) throws CustomerException {
			// TODO Auto-generated method stub
			
	Optional<Customer> opt= cr.findById(customer.getCustomerId());
			
			if(opt.isPresent()) {
				
				Customer updatedCustomer= cr.save(customer);
				return updatedCustomer;
				
			}else
				throw new CustomerException("Invalid Customer details ..please check");
			
		}

		@Override
		public Customer deleteCustomer(Customer customer) throws CustomerException {
			// TODO Auto-generated method stub
			Optional<Customer> opt= cr.findById(customer.getCustomerId());
			if(opt!=null) {
				cr.deleteById(customer.getCustomerId());
				return customer;
			}else {
				throw new CustomerException("Invalid Customer details..please provide proper details");
			}
		}

		@Override
		public Customer viewCustomer(Integer customerId) throws CustomerException {
			// TODO Auto-generated method stub
			Optional<Customer> opt= cr.findById(customerId);
			if(opt!=null) {
				
				return opt.get();
			}else {
				throw new CustomerException("Invalid Customer details..please check the details");
			}
		}

		@Override
		public List<Customer> viewAllCustomer() throws CustomerException {
			// TODO Auto-generated method stub
			List<Customer> allCustomer=cr.findAll();
			if(allCustomer!=null) {
				return allCustomer;
			}else {
				throw new CustomerException("Error! can't find the Customers");
			}
			
		}

		@Override
		public Admin addAdmin(Admin admin) throws AdminException {
			// TODO Auto-generated method stub
			Admin adminSaved=ar.save(admin);
			if(adminSaved!=null) {
				return adminSaved;
			}else {
				throw new AdminException("Admin cannot be added");
			}
			
		}

}
