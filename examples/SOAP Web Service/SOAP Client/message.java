package com.orgky.examples;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


/**
 * It represents a message to be sent.
 * msgId       : it is the string representation of the message UUID.
 * metadata    : it contains the message's Metadata
 * file        : it contains the name of the file containing the message's payload 
 */
@Slf4j
@Getter
@Setter
@Builder
public class Message {

	private String msgId;
	private Metadata metadata;	
	private String metadataString;
	private byte[] file;

}
