package com.masai.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Admin;
import com.masai.bean.CurrentUserSession;
import com.masai.bean.Customer;
import com.masai.bean.User;
import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.repository.AdminRepo;
import com.masai.repository.CustomerRepo;
import com.masai.repository.SessionRepo;
import com.masai.repository.UserRepo;
@Service
public class AdminServiceImpl implements AdminService{

	  @Autowired
		public CustomerRepo cr;
	  
	  @Autowired
	  public AdminRepo ar;
	  @Autowired
	  public UserRepo ur;
	  @Autowired
	  public SessionRepo sr;
	    
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
		public List<Customer> viewAllCustomer(String key) throws CustomerException {
			// TODO Auto-generated method stub
			CurrentUserSession loggedInUser= sr.findByUuid(key);
		
			
			if(loggedInUser != null) {

				List<Customer> allCustomer=cr.findAll();
				if(allCustomer!=null) {
					return allCustomer;
				}else {
					throw new CustomerException("Error! can't find the Customers");
				}
				
			}else {
				throw new CustomerException("Please provide a valid key to view all customer");
			}
			
			
			
		}

		@Override
		public Admin addAdmin(Admin admin) throws AdminException {
			// TODO Auto-generated method stub
			User user=new User();
//			User user=customer.getUser();
			user.setUserType("Admin");
			user.setUserPassword("Admin"+"-"+(int)Math.floor(Math.random()*(10)+1));
			User savedUser=ur.save(user);
			admin.setAdminId(savedUser.getUserId());
			admin.setUser(savedUser);
			Admin adminSaved=ar.save(admin);
		
			if(adminSaved!=null) {
				return adminSaved;
			}else {
				throw new AdminException("Admin cannot be added");
			}
			
		}

}
