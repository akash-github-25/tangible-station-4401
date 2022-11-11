package com.masai.service.report;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.Customer;
import com.masai.bean.Report;
import com.masai.exception.CustomerException;
import com.masai.exception.ReportException;
import com.masai.repository.CustomerRepo;
import com.masai.repository.ReportRepo;
@Service
public class ReportServiceImpl implements ReportService{
	 @Autowired
		public ReportRepo cr;
	@Override
	public Report addReports(Report reports) throws ReportException {
		// TODO Auto-generated method stub
		Report reportSaved=cr.save(reports);
		if(reportSaved!=null) {
			return reportSaved;
		}else {
			throw new ReportException("Report cannot be added");
		}
	}

	@Override
	public Report deleteReports(Integer reportId) throws ReportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Optional<Report> opt= cr.findById(reportId);
				if(opt!=null) {
					cr.deleteById(reportId);
					return opt.get();
				}else {
					throw new ReportException("Invalid Report details..please provide proper details");
				}
	}

	@Override
	public Report editReports(Integer reportId) throws ReportException {
		// TODO Auto-generated method stub
Optional<Report> opt= cr.findById(reportId);
		
		if(opt.isPresent()) {
			
		  Report updatedReport= cr.save(opt.get());
			return updatedReport;
			
		}else
			throw new ReportException("Invalid Report details ..please check");
		
	}

	@Override
	public Report searchReports(Integer reportId) throws ReportException {
		// TODO Auto-generated method stub
		Optional<Report> opt= cr.findById(reportId);
		if(opt!=null) {
			
			return opt.get();
		}else {
			throw new ReportException("Invalid Report details..please check the details");
		}
	}

	@Override
	public List<Report> viewAllReports() throws ReportException {
		// TODO Auto-generated method stub
	List<Report> reports=cr.findAll();
	if(reports.size()!=0) {
		return reports;
	}else {
		throw new ReportException("ReportData is not present");
	}
	}

}
