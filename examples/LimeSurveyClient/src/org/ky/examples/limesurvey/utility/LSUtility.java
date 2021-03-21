package org.ky.examples.limesurvey.utility;

import org.ky.examples.limesurvey.beans.User;

public class LSUtility {

	public String ObjToJson(Object obj, String type){
		
		String json = "";
		
		switch (type) {
		
			case "User": 
  			String firstname = ((User)obj).getFirstname();
  			String lastname = ((User)obj).getLastname();
  			String email = ((User)obj).getEmail();
  			String language = ((User)obj).getLanguage();
  			String emailstatus = ((User)obj).getEmailstatus();
  
  			json="[";
  			json = json + "{\"firstname\":\"" + firstname + "\",\"lastname\":\"" + lastname + "\","
  						+ "\"email\":\"" + email + "\",\"language\":\"" + language + "\",\"emailstatus\":\"" + emailstatus + "\"}";
  			json = json +"]";

			break;
			
			default:
			break;
			
		}
		
		return json;
	}
	
}
