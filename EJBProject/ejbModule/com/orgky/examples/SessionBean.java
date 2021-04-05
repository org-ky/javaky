package com.orgky.examples;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class SessionBean
 */
@Stateless
@Remote(EJBProjectBeanRemote.class)
public class SessionBean implements EJBProjectBeanRemote, EJBProjectBeanLocal{

	private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public SessionBean() {
        // TODO Auto-generated constructor stub
    }
    
    public void TestSessionBean(String str) {
        System.out.println("Invoke session bean method: " + str);
    }

}
