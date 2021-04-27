package com.orgky.examples.test;

import java.util.Properties;

import javax.naming.*;

import com.orgky.examples.maven.HelloEJB.HelloEjbRemote;


public class TestHelloEjb {
	
	private static InitialContext ic;
	
	public static void main( String[] args ) throws NamingException {
		System.out.println("Starting call Hello EJB");
		
		new TestHelloEjb().loadProperties("localhost", "3700");
		HelloEjbRemote helloEjb = (HelloEjbRemote) ic.lookup("java:global/HelloEJB-0.0.1-SNAPSHOT/HelloEjbImpl!com.orgky.examples.maven.HelloEJB.HelloEjbRemote");
		System.out.println("Calling sum method " + helloEjb.sum(3, 5));
	}
	
	public void loadProperties(String h, String p) {
        try {
            Properties props = new Properties();
 
            System.out.println("h: " + h + " p: " + p);
 
            props.setProperty("java.naming.factory.initial",
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs",
                    "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state",
                    "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty("org.omg.CORBA.ORBInitialHost", h);
            props.setProperty("org.omg.CORBA.ORBInitialPort", p);
 
            ic = new InitialContext(props);
        } catch (NamingException ex) {
           ex.printStackTrace();
        }
    }
}
