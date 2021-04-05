package com.orgky.examples;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.orgky.examples.EJBProjectBeanRemote;
import com.orgky.examples.SessionBean;

public class EJBProjectClient {

	public static void main(String[] args) throws Exception {
		EJBProjectBeanRemote test = lookupTestEJB();

		try {
			System.out.println("Entering the EJB");
			test.TestSessionBean("Hello");
			System.out.println("Exiting the EJB");
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	private static EJBProjectBeanRemote lookupTestEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  "org.wildfly.naming.client.WildFlyInitialContextFactory");
                jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (EJBProjectBeanRemote) context
				.lookup("ejb:/EJBProject/SessionBean!com.orgky.examples.EJBProjectBeanRemote");
	}
}