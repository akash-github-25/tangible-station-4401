package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	

}
