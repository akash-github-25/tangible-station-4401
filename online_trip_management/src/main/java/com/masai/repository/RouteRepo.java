package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Bus;
import com.masai.bean.Route;

public interface RouteRepo extends JpaRepository<Route, Integer>{

}
