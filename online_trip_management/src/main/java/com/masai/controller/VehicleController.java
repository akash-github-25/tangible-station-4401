package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Travels;
import com.masai.bean.Vehicle;
import com.masai.exception.RouteException;
import com.masai.exception.TravelsException;
import com.masai.exception.VehicleException;
import com.masai.service.vehicle.VehicleService;
@RestController
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/vehicle")
	public ResponseEntity<Vehicle> addvehicleHandler(@RequestBody Vehicle vehicle) throws VehicleException, TravelsException 
	{
		Integer travelsId=vehicle.getTravelsId();
		Vehicle vh = vehicleService.addVehicle(vehicle,travelsId);
		
		return new ResponseEntity<Vehicle>(vh, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/vehicle")
	public ResponseEntity<List<Vehicle>> viewVehicle(@RequestBody Travels travels) throws VehicleException{
		List<Vehicle> vehicle = vehicleService.viewVehicle(); 
		return new ResponseEntity<List<Vehicle>>(vehicle,HttpStatus.OK);
	}
	
	@DeleteMapping("/vehicle/{vehicleId}")
	public ResponseEntity<Vehicle> removeVehicle(@PathVariable("traveleId") int traveleId) throws RouteException, VehicleException{
		Vehicle vehicle = vehicleService.removeVehicle(traveleId);
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
	}
	
	@GetMapping("/vehicle/{vehicleId}")
	public ResponseEntity<Vehicle> searchVehicle(@PathVariable("vehicleId") int vehicleId) throws  VehicleException{
		Vehicle vehicle = vehicleService.searchVehicle(vehicleId);
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.FOUND);
	}
}
