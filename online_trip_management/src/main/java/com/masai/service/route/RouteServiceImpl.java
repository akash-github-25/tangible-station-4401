package com.masai.service.route;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Route;
import com.masai.bean.Travels;
import com.masai.bean.Vehicle;
import com.masai.exception.RouteException;
import com.masai.exception.VehicleException;
import com.masai.repository.RouteRepo;
import com.masai.repository.VehicleRepo;

@Service
public class RouteServiceImpl implements RouteService{
	@Autowired
	private RouteRepo repo  ;
	
	@Autowired
	private VehicleRepo vr;

	@Override
	public Route addRoute(Route route) throws VehicleException,RouteException {
		Integer vehicleId=route.getVehicleId();
		Optional<Vehicle> c=vr.findById(vehicleId);
		if(!c.isPresent()) {
			throw new VehicleException("Vehicle not presemt");
		}
		
		Vehicle t1=c.get();
		List<Vehicle> v=route.getVehicle();
		v.add(t1);
		route.setVehicle(v);
//		t1.setVehicle(v);
	Route rt = 	repo.save(route);
		return rt;
	}

//	@Override
//	public Route updateRoute(Integer routeId, Integer busId) throws RouteException{
//		
////		Optional<Route> opt= repo.findById(routeId);
////		
////		if(opt.isPresent()) {
////			
////			Route updatedRoute= repo.save();
////			return updatedRoute;
////			
////		}else
////			throw new RouteException("Invalid Route details..");
//		return null;
//	}

	@Override
	public Route removeRoute(int routeId) throws RouteException {
		Optional<Route> rOptional=repo.findById(routeId);
		if (!rOptional.isPresent()) {
			throw new RouteException("This Route is not present in database to delete.");
		}
		repo.delete(rOptional.get());
		return rOptional.get();
	}

	@Override
	public Route searchRoute(int routeId) throws RouteException {
		Optional<Route> rOptional=repo.findById(routeId);
		if (!rOptional.isPresent()) {
			throw new RouteException("The Route you are searching is not present in database.");
		}
		return rOptional.get();
	}

	@Override
	public List<Route> viewRouteList() throws RouteException {
		List<Route> list =repo.findAll();
		if (list.isEmpty()) {
			throw new RouteException("No route is there in database to show.");
		}
		return list;
	}
}
