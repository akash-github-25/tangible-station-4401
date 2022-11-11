package com.masai.service.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Travels;
import com.masai.bean.Vehicle;
import com.masai.exception.TravelsException;
import com.masai.exception.VehicleException;
import com.masai.repository.TravelsRepo;
import com.masai.repository.VehicleRepo;

@Service
public class VehicleServiceImpl implements VehicleService{
	@Autowired
	private VehicleRepo repo;
	
	@Autowired
	private TravelsRepo tr;
		
	@Override
	public Vehicle addVehicle(Vehicle vehicle,Integer travelsId) throws VehicleException, TravelsException {
		Optional<Travels> t=tr.findById(travelsId);
		if(!t.isPresent()) {
			throw new TravelsException("Travel not present");
		}
		Travels t1=t.get();
		List<Vehicle> v=t1.getVehicle();
		v.add(vehicle);
		t1.setVehicle(v);
		
		Vehicle vh =repo.save(vehicle);
		if(vh!=null) {
			return vh;
		}else {
			throw new VehicleException("Vehicle can't be added");
		}
		
	}


	@Override
	public Vehicle removeVehicle(Integer vehicleId) throws VehicleException {
		Optional<Vehicle> rOptional=repo.findById(vehicleId);
		if (!rOptional.isPresent()) {
			throw new VehicleException("This Vehicle is not present in database to remove");
		}
		repo.delete(rOptional.get());
		return rOptional.get();
	}


	@Override
	public Vehicle searchVehicle(Integer vehicleId) throws VehicleException {
		Optional<Vehicle> rOptional=repo.findById(vehicleId);
		if (!rOptional.isPresent()) {
			throw new VehicleException("This Vehicle is not present in database to show");
		}
		return rOptional.get();
	}


	@Override
	public List<Vehicle> viewVehicle() throws VehicleException {
	
		List<Vehicle> list=repo.findAll();
		if (list.isEmpty()) {
			throw new VehicleException("This Vehicle is not present in database to remove");
		}
		return list;
	}
	
	

}
