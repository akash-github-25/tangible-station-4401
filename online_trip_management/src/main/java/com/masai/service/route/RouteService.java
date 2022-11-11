package com.masai.service.route;

import java.util.List;

import com.masai.bean.Route;
import com.masai.exception.RouteException;
import com.masai.exception.VehicleException;

public interface RouteService {
	public Route addRoute(Route route)throws VehicleException,RouteException;
//	public Route updateRoute(Integer routeId,Integer busId) throws RouteException,BasicPathUsageException;
	public Route removeRoute(int routeId) throws RouteException;
	public Route searchRoute(int routeId) throws RouteException;
	public List<Route> viewRouteList() throws RouteException;
}
