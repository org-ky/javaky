package com.orgky.examples.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class Person {
	private String name;

	@Bean
	@Scope("singleton")
	public Person personSingleton() {
	    return new Person();
	}
}
