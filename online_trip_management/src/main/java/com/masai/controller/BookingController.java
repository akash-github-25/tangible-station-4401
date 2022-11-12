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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Booking;
import com.masai.bean.Customer;
import com.masai.bean.Hotel;
import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.exception.HotelException;
import com.masai.exception.PackageException;
import com.masai.exception.VehicleException;
import com.masai.repository.BookingRepo;
import com.masai.repository.CustomerRepo;
import com.masai.service.booking.BookingService;


@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	public BookingService bs;
	
	@Autowired
	public BookingRepo br;

//	@PostMapping("/booking")
//	public ResponseEntity<Booking> addBooking(@RequestBody Booking book) throws BookingException {
//		bs.makeBooking(book);
//		return new ResponseEntity<>(book,HttpStatus.CREATED);
//	}
	
	
	@DeleteMapping("/deleteBooking/{bookingId}")
	public ResponseEntity<Booking> deleteBooking(@PathVariable("bookingId") Integer bookingId,@RequestParam(required = false) String key) throws BookingException, CustomerException{
	    Booking book=bs.cancelBooking(br.findById(bookingId).get(),key);
		return new ResponseEntity<Booking>(book,HttpStatus.OK);
	}
	
	@GetMapping("/getBooking/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable("bookingId") Integer bookingId,@RequestParam(required = false) String key) throws BookingException, CustomerException{
		Booking book=bs.viewBooking(bookingId,key);
		return new ResponseEntity<Booking>(book,HttpStatus.OK);
}
	@GetMapping("/getAllBookings")
	public ResponseEntity<List<Booking>> viewAllBooking(@RequestParam(required = false) String key) throws BookingException, CustomerException{
		List<Booking> book=bs.viewAllBooking(key);
		return new ResponseEntity<List<Booking>>(book,HttpStatus.OK);
	}
	@PostMapping("/packages/{packageId}")
	public ResponseEntity<Booking> bookPackageHandler(@RequestBody Booking book,@PathVariable("packageId") Integer packageId,@RequestParam(required = false) String key) throws BookingException, PackageException, CustomerException{
		Booking b=bs.bookPackage(book, packageId,key);
		return new ResponseEntity<Booking>(b,HttpStatus.CREATED);
	}
	
	@PostMapping("/hotel/{hotelId}")
	public ResponseEntity<Booking> bookHotelHandler(@RequestBody Booking book,@PathVariable("hotelId") Integer hotelId,@RequestParam(required = false) String key) throws HotelException, BookingException, CustomerException{
		Booking h=bs.bookHotel(book, hotelId,key);
		return new ResponseEntity<Booking>(h,HttpStatus.CREATED);
	}
	
	@PostMapping("/vehicle/{vehicleId}")
	public ResponseEntity<Booking> bookVehicleHandler(@RequestBody Booking book,@PathVariable("vehicleId") Integer vehicleId,@RequestParam(required = false) String key) throws VehicleException, BookingException, CustomerException{
		Booking v=bs.bookVehicle(book, vehicleId,key);
		return new ResponseEntity<Booking>(v,HttpStatus.CREATED);
	}

}
