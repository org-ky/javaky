package com.orgky.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.orgky.examples.beans.ReportGenerator;
import com.orgky.examples.beans.TxtReport;

@Configuration
public class AppConfig {
 
    @Bean(name="reportService")
    public ReportGenerator reportService() 
    {
    	return new ReportGenerator();
    }
    
    @Bean(name="report")
    public TxtReport report() 
    {
    	return new TxtReport("/report");
    }
}
