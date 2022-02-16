package com.orgky.examples;

import lombok.Getter;
import lombok.Setter;

/**
 * METADATA.
 * processGroup		REQUIRED. Name of the process group the document belongs to.
 * processName		REQUIRED. Name of the process the document belongs to.
 * applReqID		REQUIRED. Can be set to provide an application specific ID 
 * 					which is put in the canonical header ApplicationReqID.
 * correlationID	REQUIRED for Req/Reply.Can be used to provide a correlation ID in a request/reply scenario.
 * 					In this case the correlationID is used to link to the same process instance.
 * 					Will be changed to process ID at a later stage.
 * applReplID		OPTIONAL. Can be set to provide an application specific reply ID in case of
 *					Request/Reply scenarios. 
 * sender			OPTIONAL. Can be set to provide a sender (3 digit format).
 * receiver			OPTIONAL. Can be set to provide a receiver (3 digit format).
 * documentVersion	OPTIONAL. Can be set to differ between different message versions.
 * typeFlag			OPTIONAL .Can be used to trigger a test message via providing a T;
 * 					other flags are not defined yet.
 * property1_Name	OPTIONAL. Applications can provide properties (need to be defined per business
 * property1_Value	process) and can use then these key words to send the name and the 
 * property2_Name	value of the properties.
 * property2_Value
 * property3_Name
 * property3_Value
 * property4_Name
 * property4_Value
 */

@Getter
@Setter
public class Metadata {
		private String processGroup;
		private String processName;
		private String applReqID;
		private String correlationID;
		private String applReplID;
		private String sender;
		private String receiver;
		private String documentVersion;
		private String typeFlag;
		private String property1Name;
		private String property1Value;
		private String property2Name;
		private String property2Value;
		private String property3Name;
		private String property3Value;
		private String property4Name;
		private String property4Value;
	
}
