package com.masai.service.travels;

import java.util.List;

import com.masai.bean.Travels;
import com.masai.exception.TravelsException;

public interface TravelsService {
	Travels addTravels(Travels travels)  throws TravelsException;
	Travels updateTravels(Travels travels) throws TravelsException;
	Travels removeTravels(int travelId) throws TravelsException;
	Travels searchTravels(int travelId) throws TravelsException;
	List<Travels> viewTravels() throws TravelsException;
}
