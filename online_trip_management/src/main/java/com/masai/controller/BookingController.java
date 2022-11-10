package com.masai.controller;

import java.util.List;

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

import com.masai.bean.Booking;
import com.masai.bean.Customer;
import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.repository.BookingRepo;
import com.masai.repository.CustomerRepo;
import com.masai.service.booking.BookingService;


@RestController
public class BookingController {

	@Autowired
	public BookingService bs;
	
	@Autowired
	public BookingRepo br;

	@PostMapping("/booking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking book) throws BookingException {
		bs.makeBooking(book);
		return new ResponseEntity<>(book,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deleteBooking/{bookingId}")
	public ResponseEntity<Booking> deleteBooking(@PathVariable("bookingId") Integer bookingId) throws BookingException{
	    Booking book=bs.cancelBooking(br.findById(bookingId).get());
		return new ResponseEntity<Booking>(book,HttpStatus.OK);
	}
	
	@GetMapping("/getBooking/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable("bookingId") Integer bookingId) throws BookingException{
		Booking book=bs.viewBooking(bookingId);
		return new ResponseEntity<Booking>(book,HttpStatus.OK);
}
	@GetMapping("/getAllBookings")
	public ResponseEntity<List<Booking>> viewAllBooking() throws BookingException{
		List<Booking> book=bs.viewAllBooking();
		return new ResponseEntity<List<Booking>>(book,HttpStatus.OK);
	}

}
