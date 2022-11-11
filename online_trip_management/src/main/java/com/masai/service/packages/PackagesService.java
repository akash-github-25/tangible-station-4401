package com.masai.service.packages;

import java.util.List;

import com.masai.bean.Packages;
import com.masai.exception.HotelException;
import com.masai.exception.PackageException;
import com.masai.exception.VehicleException;

public interface PackagesService {
	public  Packages addPackage(Packages pack) throws PackageException,HotelException,VehicleException;
	public  Packages deletePackage(Integer packageId) throws PackageException;
	public  Packages updatePackage(Integer packageId) throws PackageException;
	public  Packages searchPackage(Integer packageId) throws PackageException;
	public  List<Packages> viewAllPackage() throws PackageException;

}
