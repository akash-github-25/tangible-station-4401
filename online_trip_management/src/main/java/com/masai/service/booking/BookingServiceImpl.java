package com.masai.service.booking;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Booking;
import com.masai.bean.Customer;
import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.repository.BookingRepo;
@Service
public class BookingServiceImpl implements BookingService {
   
	@Autowired
	public BookingRepo br;

	@Override
	public Booking makeBooking(Booking book) throws BookingException {
		// TODO Auto-generated method stub

		Booking bookingDone=br.save(book);
		if(bookingDone!=null) {
			return bookingDone;
		}else {
			throw new BookingException("Booking cannot be done!");
		}
	}

	@Override
	public Booking cancelBooking(Booking book) throws BookingException {
		// TODO Auto-generated method stub
		Optional<Booking> opt= br.findById(book.getBookingId());
		if(opt!=null) {
			br.deleteById(book.getBookingId());
			return book;
		}else {
			throw new BookingException("Invalid Booking details..please provide proper details");
		}
	}

	@Override
	public Booking viewBooking(Integer bookingId) throws BookingException {
		// TODO Auto-generated method stub
		Optional<Booking> opt= br.findById(bookingId);
		if(opt!=null) {
			
			return opt.get();
		}else {
			throw new BookingException("Invalid Booking details..please provide proper details");
		}
	}

	@Override
	public List<Booking> viewAllBooking() throws BookingException {
		// TODO Auto-generated method stub
		List<Booking> allBooking=br.findAll();
		if(allBooking!=null) {
			return allBooking;
		}else {
			throw new BookingException("Error! can't find the Bookings");
		}
	}

}
