package org.ky.java.examples.limesurvey;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.ky.java.examples.limesurvey.beans.User;
import org.ky.java.examples.limesurvey.utility.LSProp;
import org.ky.java.examples.limesurvey.LSUtility;

/**
 * This example demonstrates the use of the {@link ResponseHandler} to simplify
 * the process of processing the HTTP response and releasing associated resources.
 */
public class LimeSurveyClient {

	//Authenticate data
	private static String LS_URL;			      //remotecontrol url
  private static String LS_USERNAME;		  //username
  private static String LS_PASSWORD;		  //password
    
  //LimeSurvey configuration
  private static String LS_SURVEYID;		  //Survey Id
  private static String LS_IGROUPID;		  //Group Id
  private static String LS_BCREATETOKEN;	//"0" doesn't create the Token, "1" create token
 
	public final static void main(String[] args) throws Exception {
        
    	LSUtility lsu = new LSUtility();
    	
    	User userObj = new User();
    	userObj.setFirstname("User");
    	userObj.setLastname("Test");
    	userObj.setEmail("user@test.eu");
    	userObj.setEmailstatus("OK");
    	userObj.setLanguage("it");

      //Create User's Json string    	
    	String user1 = lsu.ObjToJson(userObj, "User");

    	//Create HttpClient object
    	CloseableHttpClient client = HttpClients.createDefault();
    	String status = "";
    	
    	//Loads configuration
    	loadConf();
    	
        try {
             
        	  //Create HttpPost object
            HttpPost post = new HttpPost(LS_URL);
            		
            //Configure HttpPost object
            post.setHeader("Content-type", "application/json");
            post.setEntity( new StringEntity("{\"method\": \"get_session_key\", \"params\": {\"username\": \"" + LS_USERNAME + "\", \"password\": \"" + LS_PASSWORD + "\" }, \"id\": 1}"));

            //Get the response to authenticate request
            HttpResponse response = client.execute(post);
            
            if(response.getStatusLine().getStatusCode() == 200){
            	LOG.getLogger().info("Connection successful");
            	
                HttpEntity entity = response.getEntity();
                String sessionKey = parse(EntityUtils.toString(entity));
                
                //"add_participants" method example
                post.setEntity( new StringEntity("{\"method\": \"add_participants\", \"params\": {\"sSessionKey \": "+sessionKey+", \"iSurveyID \": \"" + LS_SURVEYID + "\", \"aParticipantData \": " +user1+ ", \"bCreateToken \": \"" + LS_BCREATETOKEN + "\", \"iGroupID\":" + LS_IGROUPID + "}, \"id\": 1}"));
                
                //"list_participants" method example
                //post.setEntity( new StringEntity("{\"method\": \"list_participants\", \"params\": {\"sSessionKey \": "+sessionKey+", \"iSurveyID \": \"" + LS_SURVEYID + "\", \"iStart\": \"0\", \"iLimit\": \"1000\", \"bUnused  \":\"false\", \"aAttributes\":[\"language\",\"attribute_1\"]}, \"id\": 1}"));
                
                response = client.execute(post);
                if(response.getStatusLine().getStatusCode() == 200){
                	HttpEntity entity2= response.getEntity();
                  String statusJson = EntityUtils.toString(entity2);
                  status = parseStatus(statusJson);
                }
               
            }

        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
          client.close();
        }

    }
    
    public static String parse(String jsonLine) {
     	 JsonElement jelement = new JsonParser().parse(jsonLine);
     	 JsonObject  jobject = jelement.getAsJsonObject();
     	 String result = jobject.get("result").toString();
     	 return result;
   	}

    public static String parseStatus(String jsonLine) {
    	 String status = "";
       JsonElement jelement = new JsonParser().parse(jsonLine);
       JsonObject  jobject = jelement.getAsJsonObject();
       JsonElement result = jobject.get("result");
       JsonObject  jobject1;
       JsonArray jarray1;
       if(result.isJsonObject()){
      	 jobject1 = result.getAsJsonObject();
       	 if(jobject1.get("status") !=null)
       		 status = jobject1.get("status").toString();
       } else if(result.isJsonArray()) {
     	   jarray1 = result.getAsJsonArray();
     	   status = "" + jarray1;
       }
       return status;
    }
    
    public static void loadConf(){
    	
    	LSProp lsprop;
  		try {
  			
  			lsprop = new LSProp();
  			LS_URL = lsprop.getLSURL();
  	    	LS_USERNAME = lsprop.getLSUSERNAME();
  	    	LS_PASSWORD = lsprop.getLSPASSWORD();
  	    	LS_SURVEYID = lsprop.getLSSURVEYID();
  	    	LS_IGROUPID = lsprop.getLSIGROUPID();
  	    	LS_BCREATETOKEN = lsprop.getLSBCREATETOKEN();
  	    	
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
    	
    }
}

