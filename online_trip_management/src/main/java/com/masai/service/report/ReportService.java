package com.masai.service.report;

import java.util.List;

import com.masai.bean.Report;
import com.masai.exception.ReportException;

public interface ReportService {

public  Report addReports(Report reports) throws ReportException;
public  Report deleteReports(Integer reportId) throws ReportException;
public  Report editReports(Integer reportId) throws ReportException;
public Report searchReports(Integer reportId) throws ReportException;
public  List<Report> viewAllReports() throws ReportException;

}
