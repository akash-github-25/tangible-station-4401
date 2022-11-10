package com.masai.service;

import java.util.List;

import com.masai.bean.Route;
import com.masai.exception.BusException;
import com.masai.exception.RouteException;

public interface RouteService {
	public Route addRoute(Route route);
	public Route updateRoute(Integer routeId,Integer busId) throws RouteException,BusException;
	public Route removeRoute(int routeId) throws RouteException;
	public Route searchRoute(int routeId) throws RouteException;
	public List<Route> viewRouteList() throws RouteException;
}