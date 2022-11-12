package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Route;
import com.masai.bean.Travels;
import com.masai.exception.RouteException;
import com.masai.exception.TravelsException;
import com.masai.service.travels.TravelsService;

@RestController
public class TravelsController {

	
	@Autowired
	private TravelsService travelsService;
	
	
	@PostMapping("/travels")
	public ResponseEntity<Travels> addTravelsHandler(@RequestBody Travels travel) throws TravelsException 
	{
		
	Travels tr = 	travelsService.addTravels(travel);
		
		return new ResponseEntity<Travels>(tr, HttpStatus.ACCEPTED);
	}
	
	
	

	@GetMapping("/travels")
	public ResponseEntity<List<Travels>> allTravles(@RequestBody Travels travels) throws TravelsException{
		List<Travels> travelsList = travelsService.viewTravels(); 
		return new ResponseEntity<List<Travels>>(travelsList,HttpStatus.OK);
	}
	
	@DeleteMapping("/travels/{traveleId}")
	public ResponseEntity<Travels> removeRoute(@PathVariable("traveleId") int traveleId) throws RouteException, TravelsException{
		Travels route = travelsService.removeTravels(traveleId);
		return new ResponseEntity<Travels>(route,HttpStatus.OK);
	}
	
	@GetMapping("/travels/{traveleId}")
	public ResponseEntity<Travels> searchRoute(@PathVariable("traveleId") int traveleId) throws RouteException, TravelsException{
		Travels route = travelsService.searchTravels(traveleId);
		return new ResponseEntity<Travels>(route,HttpStatus.FOUND);
	}
	
	@PutMapping("/travels")
	public ResponseEntity<Travels> updateTravels(@RequestBody Travels travels) throws TravelsException{
		Travels travels2 = travelsService.updateTravels(travels);
		return new ResponseEntity<Travels>(travels2,HttpStatus.OK);
	}
}
