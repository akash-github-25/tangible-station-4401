package com.masai.service.booking;

import java.util.List;

import com.masai.bean.Booking;
import com.masai.bean.Customer;
import com.masai.bean.Hotel;
import com.masai.bean.Packages;
import com.masai.bean.Vehicle;
import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.exception.HotelException;
import com.masai.exception.PackageException;
import com.masai.exception.VehicleException;

public interface BookingService {
	
	public Booking bookPackage(Booking book,Integer packageId,String key) throws BookingException,PackageException,CustomerException;
	public Booking cancelBooking(Booking book,String key)throws BookingException,CustomerException;
	public Booking viewBooking(Integer bookingId,String key)throws BookingException,CustomerException;
	public List<Booking> viewAllBooking(String key)throws BookingException,CustomerException;
	public Booking bookHotel(Booking book,Integer hotelId,String key)throws HotelException,BookingException,CustomerException;
	public Booking bookVehicle(Booking book,Integer vehicleId,String key)throws VehicleException,BookingException,CustomerException;
	
}
