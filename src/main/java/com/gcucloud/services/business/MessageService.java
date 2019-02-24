package com.gcucloud.services.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.gcucloud.model.MessageModel;
import com.gcucloud.services.data.IMessageDAO;

/**
 * Trevor Moore
 * CST-323
 * 02/14/2019
 * This assignment was completed in collaboration with Connor Low
 * This is our own work.
 * 
 * MessageService class that will hold our business logic. Implements IMessageService.
 * @author Trevor
 *
 */
public class MessageService implements IMessageService
{
	// IMessageDAO for injecting our MessageDAO
	IMessageDAO<MessageModel> messageDAO;
	/**
	 * Autowired method for setting the injected Message DAO
	 * @param dao type IMessageDAO
	 */
	@Autowired
	public void setTopicDAO(IMessageDAO<MessageModel> messageDAO)
	{
		this.messageDAO = messageDAO;
	}
	/**
	 * Method for creating a new message
	 * 
	 * @param message of type MessageModel
	 */
	public void addMessage(MessageModel message) 
	{
		// if the message sender is "Anonymous" or empty just send the body and date to the DAO
		if(message.getSender().equals("Anonymous") || message.getSender().isEmpty())
			messageDAO.addMessage(message.getMessagebody(), message.getCreationdate());
		// else send the whole message object
		else
			messageDAO.addMessage(message);
	}
	/**
	 * Method for deleting a message
	 * 
	 * @param id type int
	 */
	public void deleteMessage(int id) 
	{
		// pass the id to the DAO delete
		messageDAO.deleteMessage(id);
	}
	/**
	 * Method for updating a message
	 * 
	 * @param message type MessageModel
	 */
	public void updateMessage(MessageModel message) 
	{
		// pass message object to DAO update and return the result
		messageDAO.updateMessage(message);
	}
	/**
	 * Method for getting all the messages
	 * 
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getAll() 
	{
		// return result of a DAO getAll
		return messageDAO.getAll();
	}
	/**
	 * Method for getting a specific number of messages after the given current message ID
	 * 
	 * @param currentMessageID type int
	 * @param requestedNumberOfFollowingMessages type int
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getMessages(int currentMessageID, int requestedNumberOfFollowingMessages) 
	{
		// if the current ID is 0 just send the request messages to the DAO and return the result
		if(currentMessageID == 0)
			return messageDAO.getMessages(requestedNumberOfFollowingMessages);
		// else send the current ID and the request messages to the DAO and return the result
		else
			return messageDAO.getMessages(currentMessageID, requestedNumberOfFollowingMessages);
	}
	/**
	 * Method for loading newer messages than the most recent one loaded on the page
	 * 
	 * @param mostRecentLoadedMessageID type int
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getNewMessages(int mostRecentLoadedMessageID)
	{
		// return result of a DAO getNewMessages
		return messageDAO.getNewMessages(mostRecentLoadedMessageID);
	}
}
