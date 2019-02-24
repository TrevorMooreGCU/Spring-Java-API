package com.gcucloud.services.business;

import java.util.List;

import com.gcucloud.model.MessageModel;

/**
 * Trevor Moore
 * CST-323
 * 02/14/2019
 * This assignment was completed in collaboration with Connor Low
 * This is our own work.
 * 
 * IMessageService interface for defining our "method" contract.
 * @author Trevor
 *
 */
public interface IMessageService 
{
	/**
	 * Method for creating a new message
	 * 
	 * @param message of type MessageModel
	 */
	public void addMessage(MessageModel message);
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
	public void updateMessage(MessageModel message);
	/**
	 * Method for getting all the messages
	 * 
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getAll();
	/**
	 * Method for getting a specific number of messages after the given current message ID
	 * 
	 * @param currentMessageID type int
	 * @param requestedNumberOfFollowingMessages type int
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getMessages(int currentMessageID, int requestedNumberOfFollowingMessages);
	/**
	 * Method for loading newer messages than the most recent one loaded on the page
	 * 
	 * @param mostRecentLoadedMessageID type int
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getNewMessages(int mostRecentLoadedMessageID);
}
