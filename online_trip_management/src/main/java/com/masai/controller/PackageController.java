package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.bean.Hotel;
import com.masai.bean.Packages;
import com.masai.exception.HotelException;
import com.masai.exception.PackageException;
import com.masai.exception.VehicleException;
import com.masai.repository.PackageRepo;
import com.masai.service.packages.PackagesService;
@RestController
public class PackageController {
	
	@Autowired
	public  PackagesService pr;
	
	@PostMapping("/package")
	public ResponseEntity<Packages> savePackage(@RequestBody Packages packages) throws  PackageException, HotelException, VehicleException {
	 Packages p=pr.addPackage(packages);
		return new ResponseEntity<>(packages,HttpStatus.CREATED);
	}
}
