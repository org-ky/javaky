package org.ky.examples.limesurvey.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class LSProp {

	private FileInputStream fileInput;
	private String LSURL;
	private String LSUSERNAME;
	private String LSPASSWORD;
	private String LSBCREATETOKEN;
	private String LSSURVEYID;
	private String LSIGROUPID;

	public LSProp() throws IOException {
		try {
			Properties prop = new Properties();
			String propFileName = "resources/config.properties";
			fileInput = new FileInputStream(propFileName);
 
			if (fileInput != null) {
				prop.load(fileInput);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and set the class attribute
			setLSURL(prop.getProperty("lsurl"));
			setLSUSERNAME(prop.getProperty("lsusername"));
			setLSPASSWORD(prop.getProperty("lspassword"));
			setLSSURVEYID(prop.getProperty("lssurveyid"));
			setLSIGROUPID(prop.getProperty("lsigroupid"));
			setLSBCREATETOKEN(prop.getProperty("lsbcreatetoken"));
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			fileInput.close();
		}
		
	}

	public String getLSURL() {
		return LSURL;
	}

	public void setLSURL(String lSURL) {
		LSURL = lSURL;
	}

	public String getLSUSERNAME() {
		return LSUSERNAME;
	}

	public void setLSUSERNAME(String lSUSERNAME) {
		LSUSERNAME = lSUSERNAME;
	}

	public String getLSPASSWORD() {
		return LSPASSWORD;
	}

	public void setLSPASSWORD(String lSPASSWORD) {
		LSPASSWORD = lSPASSWORD;
	}

	public String getLSBCREATETOKEN() {
		return LSBCREATETOKEN;
	}

	public void setLSBCREATETOKEN(String lSBCREATETOKEN) {
		LSBCREATETOKEN = lSBCREATETOKEN;
	}

	public String getLSSURVEYID() {
		return LSSURVEYID;
	}

	public void setLSSURVEYID(String lSSURVEYID) {
		LSSURVEYID = lSSURVEYID;
	}

	public String getLSIGROUPID() {
		return LSIGROUPID;
	}

	public void setLSIGROUPID(String lSIGROUPID) {
		LSIGROUPID = lSIGROUPID;
	}
	
	
}
