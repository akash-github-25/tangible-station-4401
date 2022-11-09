package com.masai.service;

import java.util.List;

import com.masai.bean.Customer;
import com.masai.exception.CustomerException;

public interface CustomerService {
	
public Customer addCustomer(Customer customer) throws CustomerException;
public Customer updateCustomer(Customer customer)throws CustomerException;
public Customer deleteCustomer(Customer customer)throws CustomerException;
public Customer viewCustomer(Integer customerId)throws CustomerException;
public List<Customer> viewAllCustomer()throws CustomerException;

}
