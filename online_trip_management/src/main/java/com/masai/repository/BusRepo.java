package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Bus;
//import com.masai.bean.Customer;

public interface BusRepo extends JpaRepository<Bus, Integer>{

}
