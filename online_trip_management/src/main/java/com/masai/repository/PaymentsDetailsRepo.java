package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Booking;
import com.masai.bean.PayementDetails;

public interface PaymentsDetailsRepo extends JpaRepository<PayementDetails, Integer>{

}
