package com.orgky.examples.maven.HelloEJB;

import java.io.Serializable;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote
public class HelloEjbImpl implements HelloEjbRemote, Serializable{

	@Override
	@RolesAllowed("g1")
	public int sum(int a, int b) {
		System.out.println("Calling HelloEjb!");
		return a+b;
	}

}
