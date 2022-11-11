package com.masai.service.vehicle;

import java.util.List;

import com.masai.bean.Vehicle;
import com.masai.exception.TravelsException;
import com.masai.exception.VehicleException;

public interface VehicleService {
	public Vehicle addVehicle(Vehicle vehicle,Integer travelsId)  throws VehicleException, TravelsException;
	public Vehicle removeVehicle(Integer vehicleId) throws VehicleException;
	public Vehicle searchVehicle(Integer vehicleId) throws VehicleException;
	public List<Vehicle> viewVehicle() throws VehicleException;
}
