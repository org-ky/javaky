package com.orgky.examples.factory;

import com.orgky.examples.beans.ReportGenerator;
import com.orgky.examples.beans.TxtReport;

public class ReportGeneratorFactory {

	public static ReportGenerator createTxtReportGenerator() {

		ReportGenerator rg = new ReportGenerator();

		rg.setReport(new TxtReport("/report"));

		return rg;
	}
}
