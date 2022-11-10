package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Admin;
import com.masai.bean.Booking;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
