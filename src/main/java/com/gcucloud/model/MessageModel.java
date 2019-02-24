package com.gcucloud.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Trevor Moore
 * CST-323
 * 02/14/2019
 * This assignment was completed in collaboration with Connor Low
 * This is our own work.
 * 
 * MessageModel class to carry and encapsulate message data.
 * @author Trevor
 *
 */
public class MessageModel 
{
	private String id;
	
	@NotNull(message="Message field cannot be left blank.")
	@Size(min=1, max=500, message="Message must be between 1 and 500 characters.")
	private String messagebody;
	
	private String creationdate;
	
	private String sender;

	/**
	 * Default constructor
	 */
	public MessageModel()
	{
		this.id = "";
		this.messagebody = "";
		this.creationdate = "";
		this.sender = "";
	}

	/**
	 * Non-default constructor
	 * @param id type String
	 * @param messagebody type String
	 * @param creationdate type String
	 * @param sender type String
	 */
	public MessageModel(String id, String messagebody, String creationdate, String sender) 
	{
		super();
		this.id = id;
		this.messagebody = messagebody;
		this.creationdate = creationdate;
		this.sender = sender;
	}

	/// GETTERS AND SETTERS ///
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessagebody() {
		return messagebody;
	}
	public void setMessagebody(String messagebody) {
		this.messagebody = messagebody;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
}
