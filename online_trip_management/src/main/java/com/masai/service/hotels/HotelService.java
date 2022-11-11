package com.masai.service.hotels;

import java.util.List;

import com.masai.bean.Hotel;
import com.masai.exception.HotelException;

public interface HotelService {
	
	public Hotel addHotels(Hotel hotel) throws HotelException;
	public Hotel updateHotel(Hotel hotels) throws HotelException;
	public Hotel removeHotel(Integer hotelId) throws HotelException;
	public Hotel searchHotel(Integer hotelId)throws HotelException;
	public List<Hotel> viewHotels() throws HotelException;

}
