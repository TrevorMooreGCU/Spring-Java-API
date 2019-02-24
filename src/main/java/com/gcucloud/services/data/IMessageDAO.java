package com.gcucloud.services.data;

import java.util.List;

/**
 * Trevor Moore
 * CST-323
 * 02/14/2019
 * This assignment was completed in collaboration with Connor Low
 * This is our own work.
 * 
 * IMessageDAO interface for defining the "method" contract.
 * @author Trevor
 *
 */
public interface IMessageDAO <M>
{
	/**
	 * (OVERLOADED METHOD)
	 * Method for creating a new message with a defined sender
	 * 
	 * @param message of type MessageModel
	 */
	public void addMessage(M message);
	/**
	 * (OVERLOADED METHOD)
	 * Method for creating a new message with an anonymous sender
	 * 
	 * @param message of type MessageModel
	 */
	public void addMessage(String messageBody, String creationDate);
	/**
	 * Method for deleting a message
	 * 
	 * @param id type int
	 */
	public void deleteMessage(int id);
	/**
	 * Method for updating a message
	 * 
	 * @param message type MessageModel
	 */
	public void updateMessage(M message);
	/**
	 * Method for getting all the messages
	 * 
	 * @return type ListMessageModel
	 */
	public List<M> getAll();
	/**
	 * (OVERLOADED METHOD)
	 * Method for getting a specific number of messages after the given current message ID
	 * 
	 * @param currentMessageID type int
	 * @param requestedNumberOfFollowingMessages type int
	 * @return type ListMessageModel
	 */
	public List<M> getMessages(int currentMessageID, int requestedNumberOfFollowingMessages);
	/**
	 * (OVERLOADED METHOD)
	 * Method for getting a specific number of messages including and after the most recent message
	 * 
	 * @param requestedNumberOfMessages type int
	 * @return type ListMessageModel
	 */
	public List<M> getMessages(int requestedNumberOfMessages);
	/**
	 * Method for loading newer messages than the most recent one loaded on the page
	 * 
	 * @param mostRecentLoadedMessageID type int
	 * @return type ListMessageModel
	 */
	public List<M> getNewMessages(int mostRecentLoadedMessageID);
}
