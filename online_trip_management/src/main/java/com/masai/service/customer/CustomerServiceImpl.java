package com.masai.service.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Booking;
import com.masai.bean.CurrentUserSession;
import com.masai.bean.Customer;
import com.masai.bean.User;
import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.repository.CustomerRepo;
import com.masai.repository.SessionRepo;
import com.masai.repository.UserRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
	public CustomerRepo cr;
    
    @Autowired
    public UserRepo ur;
    
    @Autowired
    public SessionRepo sr;
    
   
    
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		User user=new User();
//		User user=customer.getUser();
		user.setUserType("customer");
		user.setUserPassword("customer"+"-"+(int)Math.floor(Math.random()*(10)+1));
		User savedUser=ur.save(user);
		customer.setCustomerId(savedUser.getUserId());
//		customer.setUser(savedUser);
		Customer customerSaved=cr.save(customer);

		
		if(customerSaved!=null) {
			return customerSaved;
		}else {
			throw new CustomerException("Customer cannot be added");
		}
		
	}

	@Override
	public Customer updateCustomer(Customer customer,String key) throws CustomerException {
		// TODO Auto-generated method stub
		CurrentUserSession loggedInUser= sr.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		

			if(customer.getCustomerId()==loggedInUser.getUserId()) {
			
			Customer updatedCustomer= cr.save(customer);
			
			return updatedCustomer;

			
		}else
			throw new CustomerException("Invalid Customer details ..please check");
		
	}

	@Override
	public Customer deleteCustomer(Customer customer,String key) throws CustomerException {
		
				CurrentUserSession loggedInUser= sr.findByUuid(key);
				
				if(loggedInUser == null) {
					throw new CustomerException("Please provide a valid key to delete a customer");
				}
				

					if(customer.getCustomerId()==loggedInUser.getUserId()) {
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
	public List<Booking> viewAllBooking(Integer customerId) throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
