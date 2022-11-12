package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Customer;
import com.masai.bean.Hotel;
import com.masai.exception.CustomerException;
import com.masai.exception.HotelException;
import com.masai.repository.HotelRepo;
import com.masai.service.hotels.HotelService;

@RestController
public class HotelController {
	@Autowired
	public HotelService hs;
	@Autowired
	 public HotelRepo hr;

	@PostMapping("/hotel")
	public ResponseEntity<Hotel> saveCustomer(@RequestBody Hotel hotel) throws  HotelException {
		hs.addHotels(hotel);
		return new ResponseEntity<>(hotel,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateHotel")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) throws HotelException{
		Hotel hotels=hs.updateHotel(hotel);
		return new ResponseEntity<Hotel>(hotels,HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping("/deleteHotel/{hotelId}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("hotelId") Integer hotelId) throws HotelException{
		Hotel custom=hs.removeHotel(hotelId);
		return new ResponseEntity<Hotel>(custom,HttpStatus.OK);
	}
	
	@GetMapping("/getHotel/{hotelId}")
	public ResponseEntity<Hotel> viewHotel(@PathVariable("hotelId") Integer hotelId) throws HotelException{
		Hotel custom=hs.searchHotel(hotelId);
		return new ResponseEntity<Hotel>(custom,HttpStatus.OK);
}
}
