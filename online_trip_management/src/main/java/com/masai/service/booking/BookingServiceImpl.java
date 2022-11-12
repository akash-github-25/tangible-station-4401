package com.masai.service.booking;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Booking;
import com.masai.bean.CurrentUserSession;
import com.masai.bean.Customer;
import com.masai.bean.Hotel;
import com.masai.bean.Packages;
import com.masai.bean.Vehicle;
import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.exception.HotelException;
import com.masai.exception.PackageException;
import com.masai.exception.VehicleException;
import com.masai.repository.AdminRepo;
import com.masai.repository.BookingRepo;
import com.masai.repository.CustomerRepo;
import com.masai.repository.HotelRepo;
import com.masai.repository.PackageRepo;
import com.masai.repository.SessionRepo;
import com.masai.repository.VehicleRepo;
import com.masai.service.admin.AdminService;
import com.masai.service.customer.CustomerService;
import com.masai.service.hotels.HotelService;
import com.masai.service.packages.PackagesService;
import com.masai.service.vehicle.VehicleService;
@Service
public class BookingServiceImpl implements BookingService {
   
	@Autowired
	public BookingRepo br;
	@Autowired
	public PackageRepo pr;
	@Autowired
	public PackagesService ps;
	@Autowired
	public HotelRepo hr;
	@Autowired
	public HotelService hs;
	@Autowired
	public VehicleRepo vr;
	@Autowired
	public VehicleService vs;
	@Autowired
	public SessionRepo sr;

//	@Override
//	public Booking makeBooking(Booking book) throws BookingException {
//		// TODO Auto-generated method stub
//
//		Booking bookingDone=br.save(book);
//		if(bookingDone!=null) {
//			return bookingDone;
//		}else {
//			throw new BookingException("Booking cannot be done!");
//		}
//	}

	@Override
	public Booking cancelBooking(Booking book,String key) throws BookingException, CustomerException {
		// TODO Auto-generated method stub
CurrentUserSession loggedInUser= sr.findByUuid(key);
		
		if(loggedInUser != null) {
		Optional<Booking> opt= br.findById(book.getBookingId());
		if(opt!=null) {
			br.deleteById(book.getBookingId());
			return book;
		}else {
			throw new BookingException("Invalid Booking details..please provide proper details");
		}
		}else {
			throw new CustomerException("Please provide a valid key");
		}
	}

	@Override
	public Booking viewBooking(Integer bookingId,String key) throws BookingException, CustomerException {
		// TODO Auto-generated method stub
		CurrentUserSession loggedInUser= sr.findByUuid(key);
		
		if(loggedInUser != null) {
		Optional<Booking> opt= br.findById(bookingId);
		if(opt!=null) {
			
			return opt.get();
		}else {
			throw new BookingException("Invalid Booking details..please provide proper details");
		}
		}else {
			throw new CustomerException("Please provide a valid key");
		}
	}

	@Override
	public List<Booking> viewAllBooking(String key) throws BookingException, CustomerException {
		// TODO Auto-generated method stub
		 CurrentUserSession loggedInUser= sr.findByUuid(key);
			
			if(loggedInUser != null) {
		List<Booking> allBooking=br.findAll();
		if(allBooking!=null) {
			return allBooking;
		}else {
			throw new BookingException("Error! can't find the Bookings");
		}
			}else {
				throw new CustomerException("Please provide a valid key");
			}
	}

	@Override
	public Booking bookPackage(Booking book,Integer packageId,String key) throws BookingException, PackageException, CustomerException {
		// TODO Auto-generated method stub
        CurrentUserSession loggedInUser= sr.findByUuid(key);
		
		if(loggedInUser != null) {
			
		

		
		Optional<Packages> v=pr.findById(packageId);
		if(v.isPresent()) {
			book.setPackages(v.get());
		}else {
			throw new PackageException("Package can't be added");
		}
		Booking bookingDone=br.save(book);
		if(bookingDone!=null) {
			return bookingDone;
		}else {
			throw new BookingException("Booking cannot be done!");
		}
		}else {
			throw new CustomerException("Please provide a valid key");
		}
		
	}

	@Override
	public Booking bookHotel(Booking book,Integer hotelId,String key) throws HotelException, BookingException, CustomerException {
		// TODO Auto-generated method stub
		  CurrentUserSession loggedInUser= sr.findByUuid(key);
			
			if(loggedInUser != null) {
		Optional<Hotel> h=hr.findById(hotelId);
		if(h.isPresent()) {
			book.setHotel(h.get());
		}else {
			throw new HotelException("Hotel can't be booked");
		}
	
		Booking bookingDone=br.save(book);
		if(bookingDone!=null) {
			return bookingDone;
		}else {
			throw new BookingException("Booking cannot be done!");
		}
			}else {
				throw new CustomerException("Please provide a valid key");
			}
		
		
	
	}

	@Override
	public Booking bookVehicle(Booking book,Integer vehicleId,String key) throws VehicleException, BookingException, CustomerException {
		// TODO Auto-generated method stub
		 CurrentUserSession loggedInUser= sr.findByUuid(key);
			
			if(loggedInUser != null) {
		Optional<Vehicle> v=vr.findById(vehicleId);
		if(v.isPresent()) {
			book.setVehicle(v.get());
		}else {
			throw new VehicleException("Vehicle can't be added");
		}
		Booking bookingDone=br.save(book);
		if(bookingDone!=null) {
			return bookingDone;
		}else {
			throw new BookingException("Booking cannot be done!");
		}
			}else {
				throw new CustomerException("Please provide a valid key");
			}
	}

}
