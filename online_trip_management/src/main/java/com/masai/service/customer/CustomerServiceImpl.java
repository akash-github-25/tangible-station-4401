package com.masai.service.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Booking;
import com.masai.bean.Customer;
import com.masai.bean.User;
import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.repository.CustomerRepo;
import com.masai.repository.UserRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
	public CustomerRepo cr;
    
    @Autowired
    public UserRepo ur;
    
   
    
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		User user=new User();
//		User user=customer.getUser();
		user.setUserType("customer");
		user.setUserPassword("customer"+"-"+(int)Math.floor(Math.random()*(10)+1));
		User savedUser=ur.save(user);
		customer.setCustomerId(savedUser.getUserId());
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
	public List<Booking> viewAllBooking(Integer customerId) throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
