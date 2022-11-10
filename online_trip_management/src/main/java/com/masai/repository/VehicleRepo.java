package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Booking;
import com.masai.bean.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{

}
