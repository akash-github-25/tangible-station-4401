package com.masai.service.hotels;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Customer;
import com.masai.bean.Feedback;
import com.masai.bean.Hotel;
import com.masai.exception.CustomerException;
import com.masai.exception.FeedbackException;
import com.masai.exception.HotelException;
import com.masai.repository.HotelRepo;
@Service
public class HotelServiceImpl implements HotelService{
	
@Autowired	
public HotelRepo hr;

	@Override
	public Hotel addHotels(Hotel hotel) throws HotelException {
		// TODO Auto-generated method stub
	
		Hotel fb=hr.save(hotel);
		if(fb!=null) {
			return fb;
		}else {
			throw new HotelException("Hotel can't be added");
		}
	}

	@Override
	public Hotel updateHotel(Hotel hotels) throws HotelException {
		// TODO Auto-generated method stub
Optional<Hotel> opt= hr.findById(hotels.getHotelId());
		
		if(opt.isPresent()) {
			
			Hotel updatedHotel= hr.save(hotels);
			return updatedHotel;
			
		}else
			throw new HotelException("Invalid hotel details ..please check");
		
	}

	@Override
	public Hotel removeHotel(Integer hotelId) throws HotelException {
		// TODO Auto-generated method stub
		Optional<Hotel> opt= hr.findById(hotelId);
		if(opt!=null) {
			hr.deleteById(hotelId);
			return opt.get();
		}else {
			throw new HotelException("Invalid Hotel details..please provide proper details");
		}
	}

	@Override
	public Hotel searchHotel(Integer hotelId) throws HotelException {
		// TODO Auto-generated method stub
		Optional<Hotel> opt= hr.findById(hotelId);
		if(opt!=null) {
			
			return opt.get();
		}else {
			throw new HotelException("Invalid Hotel details..please check the details");
		}
	}

	@Override
	public List<Hotel> viewHotels() throws HotelException {
		// TODO Auto-generated method stub
		List<Hotel> hotels= hr.findAll();
		if(hotels.size()!=0) {
			return hotels;
		}else {
			throw new HotelException("No hotel is present to show");
		}
	}
	
	
	

}
