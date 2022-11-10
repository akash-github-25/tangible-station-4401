package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Booking;
import com.masai.bean.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer>{

}
