package com.orgky.examples.beans;

import org.springframework.beans.factory.annotation.Autowired;

//Classe ReportGenerator
public class ReportGenerator {

	@Autowired
	Report report;

	public Report generate(String data) {
		//report = new TxtReport(); 
		report.generate(data);
		return report;
	}
	
	public void setReport (Report report) {
		this.report = report;
	}
}
