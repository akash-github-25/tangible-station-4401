package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.bean.Booking;
import com.masai.bean.Travels;

public interface TravelsRepo extends JpaRepository<Travels, Integer>{

}
