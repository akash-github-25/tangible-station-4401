package com.masai.service.booking;

import java.util.List;

import com.masai.bean.Booking;
import com.masai.bean.Customer;
import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;

public interface BookingService {
	
	public Booking makeBooking(Booking book) throws BookingException;
	public Booking cancelBooking(Booking bbok)throws BookingException;
	public Booking viewBooking(Integer bookingId)throws BookingException;
	public List<Booking> viewAllBooking()throws BookingException;
}
