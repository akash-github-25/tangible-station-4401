package com.masai.service.packages;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Hotel;
import com.masai.bean.Packages;
import com.masai.bean.Vehicle;
import com.masai.exception.HotelException;
import com.masai.exception.PackageException;
import com.masai.exception.VehicleException;
import com.masai.repository.HotelRepo;
import com.masai.repository.PackageRepo;
import com.masai.repository.VehicleRepo;

@Service
public class PackagesServiceImpl implements PackagesService{
	
@Autowired
private PackageRepo pr;

@Autowired
private HotelRepo hr;

@Autowired
private VehicleRepo vr;

	@Override
	public Packages addPackage(Packages pack) throws PackageException, HotelException,VehicleException {
		// TODO Auto-generated method stub
		
		Integer h=pack.getHotelId();
//		if(h!=null) {
		Optional<Hotel> f=hr.findById(h);
		if(!f.isPresent()) {
			throw new HotelException("Hotel is not added");
		}
		Hotel g=f.get();
//		System.out.println(g+"***********************************************");
//		pack.setPackageDescription(g+"*******************************");
		List<Hotel> b=pack.getHotels();
		b.add(g);
		pack.setHotels(b);
//		}
    
		Integer h1=pack.getVehicleId();
//		if(h1!=null) {
		Optional<Vehicle> f1=vr.findById(h1);
		if(!f1.isPresent()) {
			throw new VehicleException("Vehicle is not added");
		}
		Vehicle v=f1.get();
		if(v==null) {
			throw new VehicleException("Vehicle is not added");
		}
		
		List<Vehicle> c=pack.getVehicle();
		c.add(v);
		pack.setVehicle(c);
//		}
		
		
		Packages p=pr.save(pack);
		if(p!=null) {
			return p;
		}else {
			throw new PackageException("Package is not added");
		}
		
	}

	@Override
	public Packages deletePackage(Integer packageId) throws PackageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Packages updatePackage(Integer packageId) throws PackageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Packages searchPackage(Integer packageId) throws PackageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Packages> viewAllPackage() throws PackageException {
		// TODO Auto-generated method stub
		return null;
	}

}
