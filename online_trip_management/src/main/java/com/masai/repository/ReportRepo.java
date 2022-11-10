package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Booking;
import com.masai.bean.Report;

public interface ReportRepo extends JpaRepository<Report, Integer>{

}
