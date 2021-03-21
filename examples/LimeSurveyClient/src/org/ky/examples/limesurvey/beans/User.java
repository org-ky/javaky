package org.ky.examples.limesurvey.beans;

public class User {

	private String firstname;
	private String lastname;
	private String email;
	private String language;
	private String emailstatus;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		if(firstname != null)
			this.firstname = firstname;
		else
			this.firstname = "";
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		if(lastname != null)
			this.lastname = lastname;
		else
			this.lastname = "";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email != null)
			this.email = email;
		else
			this.email = "";
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		if(language != null)
			this.language = language;
		else
			this.language = "";
	}
	public String getEmailstatus() {
		return emailstatus;
	}
	public void setEmailstatus(String emailstatus) {
		if(emailstatus != null)
			this.emailstatus = emailstatus;
		else
			this.emailstatus = "";
	}
	
	
}
