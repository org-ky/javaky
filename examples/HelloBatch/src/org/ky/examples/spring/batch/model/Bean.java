package org.ky.examples.spring.batch.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "record")
public class Bean {

	
	private String Firstname;
	private String Lastname;
	private String Email;

	public Bean() {
	}

    public Bean(String nome, String cognome, String email) {
        this.Firstname = nome;
        this.Lastname = cognome;
        this.Email = email;
    }
	
	@XmlAttribute(name = "FirstName")
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String nome) {
		Firstname = nome;
	}
	
	@XmlAttribute(name = "Lastname")
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String cognome) {
		Lastname = cognome;
	}
	
	@XmlAttribute(name = "Email")
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}


	@Override
	public String toString() {
		return "Bean [Nome=" + Firstname + ", Cognome=" + Lastname + ", Email=" + Email + "]";
	}
	
}
