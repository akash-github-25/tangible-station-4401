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

import com.masai.bean.Route;
import com.masai.exception.RouteException;
import com.masai.exception.VehicleException;
import com.masai.service.route.RouteService;

@RestController
public class RouteController {
		@Autowired
		 private RouteService routeService;

	@PostMapping("/routes")
	public ResponseEntity<Route> addRoute(@RequestBody Route route) throws VehicleException, RouteException
	{
		Route route2 = routeService.addRoute(route);
		return new ResponseEntity<Route>(route2,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRoutes() throws RouteException{
		List<Route> routeList = routeService.viewRouteList();
		return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK);
	}
	
	@DeleteMapping("/routes/{routeId}")
	public ResponseEntity<Route> removeRoute(@PathVariable("routeId") int routeId) throws RouteException{
		Route route = routeService.removeRoute(routeId);
		return new ResponseEntity<Route>(route,HttpStatus.OK);
	}
	
	@GetMapping("/routes/{routeId}")
	public ResponseEntity<Route> searchRoute(@PathVariable("routeId") int routeId) throws RouteException{
		Route route = routeService.searchRoute(routeId);
		return new ResponseEntity<Route>(route,HttpStatus.FOUND);
	}
	
	
}
