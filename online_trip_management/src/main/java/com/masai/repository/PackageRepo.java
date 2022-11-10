package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Booking;
import com.masai.bean.Packages;

public interface PackageRepo extends JpaRepository<Packages, Integer>{

}
