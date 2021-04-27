package com.orgky.examples.maven.HelloEJB;

import javax.ejb.Remote;

@Remote
public interface HelloEjbRemote {
	public int sum(int a, int b);	
}
