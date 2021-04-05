package com.orgky.examples;

import jakarta.ejb.Remote;

@Remote
public interface EJBProjectBeanRemote extends EJBProjectBeanIF{

	public void TestSessionBean(String str);
}
