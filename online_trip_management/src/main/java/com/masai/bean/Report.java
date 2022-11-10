package com.masai.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to autogenerate ID.	
private Integer reportId;
private String reportName;
private String reportType;
private String reportDescription;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "admin_id", referencedColumnName = "adminId")
public Admin admin;

public Report(Integer reportId, String reportName, String reportType, String reportDescription, Admin admin) {
	super();
	this.reportId = reportId;
	this.reportName = reportName;
	this.reportType = reportType;
	this.reportDescription = reportDescription;
	this.admin = admin;
}

public Report() {
	super();
	// TODO Auto-generated constructor stub
}

public Integer getReportId() {
	return reportId;
}

public void setReportId(Integer reportId) {
	this.reportId = reportId;
}

public String getReportName() {
	return reportName;
}

public void setReportName(String reportName) {
	this.reportName = reportName;
}

public String getReportType() {
	return reportType;
}

public void setReportType(String reportType) {
	this.reportType = reportType;
}

public String getReportDescription() {
	return reportDescription;
}

public void setReportDescription(String reportDescription) {
	this.reportDescription = reportDescription;
}

public Admin getAdmin() {
	return admin;
}

public void setAdmin(Admin admin) {
	this.admin = admin;
}




}
