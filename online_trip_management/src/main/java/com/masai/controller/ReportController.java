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

import com.masai.bean.Customer;
import com.masai.bean.Feedback;
import com.masai.bean.Report;
import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.exception.FeedbackException;
import com.masai.exception.ReportException;
import com.masai.service.admin.AdminService;
import com.masai.service.customer.CustomerService;
import com.masai.service.feedback.FeedbackService;
import com.masai.service.report.ReportService;

@RestController
public class ReportController {
	
	@Autowired
	public ReportService fs;
	@Autowired
	public AdminService cs;
	
	@PostMapping("/report")
	public ResponseEntity<Report> saveFeedback(@RequestBody Report report) throws AdminException, ReportException {

		Report f=fs.addReports(report);
		return new ResponseEntity<Report>(f,HttpStatus.CREATED);
	}
	
	@GetMapping("/getReportbyReportId/{reportId}")
	public ResponseEntity<Report> viewReportbyReportId(@PathVariable("reportId") Integer reportId) throws AdminException, ReportException{
		Report feed=fs.searchReports(reportId);
		return new ResponseEntity<Report>(feed,HttpStatus.OK);
}
	
	@GetMapping("/getAllReports")
	public ResponseEntity<List<Report>> viewAllReports() throws ReportException{
		List<Report> feed=fs.viewAllReports();
		return new ResponseEntity<List<Report>>(feed,HttpStatus.OK);
	}
	@DeleteMapping("/deleteReport/{reportId}")
	public ResponseEntity<Report> deleteReport(@PathVariable("reportId") Integer reportId) throws AdminException, ReportException{
		Report d=fs.deleteReports(reportId);
		return new ResponseEntity<Report>(d,HttpStatus.OK);
	}

}
