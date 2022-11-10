package com.masai.service.customer;

import java.util.List;

import com.masai.bean.Booking;
import com.masai.bean.Customer;
import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;

public interface CustomerService {
	
public Customer addCustomer(Customer customer) throws CustomerException;
public Customer updateCustomer(Customer customer)throws CustomerException;
public Customer deleteCustomer(Customer customer)throws CustomerException;
public Customer viewCustomer(Integer customerId)throws CustomerException;
public List<Booking> viewAllBooking(Integer customerId)throws BookingException;

}
