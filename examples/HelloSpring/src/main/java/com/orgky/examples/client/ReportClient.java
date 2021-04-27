package com.orgky.examples.client;

import org.springframework.beans.factory.*;

import org.springframework.beans.factory.xml.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import com.orgky.examples.config.AppConfig;

import com.orgky.examples.beans.ReportGenerator;

public class ReportClient {
	
	private static ApplicationContext context;

	/*public static void main(String[] args) {

		String data = null;*/
		
		/*
		//Chiamata al bean utilizzando il file beans.xml presente in src/main/resources
		context = new ClassPathXmlApplicationContext("beans.xml");
		ReportGenerator gen = (ReportGenerator) context.getBean("reportGenerator");
		gen.generate(data).saveToFile();
		*/
		
		/*
		//Chiamata al bean utilizzando le annotation e la class di configurazione AppConfig
		*/
		/*ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ReportGenerator  gen = (ReportGenerator) context.getBean("reportService");
	    gen.generate(data).saveToFile();
	}*/
}
