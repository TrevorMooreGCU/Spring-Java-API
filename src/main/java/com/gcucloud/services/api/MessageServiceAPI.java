package com.gcucloud.services.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcucloud.model.MessageModel;
import com.gcucloud.services.business.IMessageService;

/**
 * Trevor Moore
 * CST-323
 * 02/14/2019
 * This assignment was completed in collaboration with Connor Low
 * This is our own work.
 * 
 * MessageServiceAPI class for exposing the API to be consumed.
 * @author Trevor
 *
 */
@RestController
@RequestMapping("/messaging")
@CrossOrigin(origins = "*")
public class MessageServiceAPI 
{
	// Injected MessageService dependency
	IMessageService messageService;
	
	// Autowire the dependency
	@Autowired
	public void setMessageService(IMessageService messageService) 
	{
		this.messageService = messageService;
	}
	/**
	 * Path: /messaging/getall
	 * RequestType: GET
	 * Description: Will return all messages from the database, most recent first
	 * Produces: JSON
	 * @return List of MessageModel JSON
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
	public List<MessageModel> getAll()
	{
		// returning the list of MessageModels using injected dependency calling getAll
		return messageService.getAll();
	}
	/**
	 * Path: /messaging/getmessages
	 * RequestType: GET
	 * Description: Will return "count" amount of messages after the given "index"
	 * Produces: JSON
	 * @param index type int (query param)
	 * @param count type int (query param)
	 * @return List of MessageModel JSON
	 */
	@RequestMapping(value = "/getmessages", method = RequestMethod.GET, produces = "application/json")
	public List<MessageModel> getMessages(@RequestParam(value = "index", required = true) int index, 
			@RequestParam(value = "count", required = true) int count)
	{
		// returning the list of MessageModels using injected dependency calling getMessages
		return messageService.getMessages(index, count);
	}
	/**
	 * Path: /messaging/sendmessage
	 * RequestType: POST
	 * Description: Will send a message
	 * Consumes: JSON
	 * @param message type MessageModel JSON (request body)
	 */
	@RequestMapping(value = "/sendmessage", method = RequestMethod.POST, consumes = "application/json")
	public void sendMessage(@RequestBody MessageModel message) 
	{
		// call addMessage using injected dependency passing in the message
	    messageService.addMessage(message);
	}
	/**
	 * Path: /messaging/updatemessage
	 * RequestType: PUT
	 * Description: Will update a message based off of ID
	 * Consumes: JSON
	 * @param message type MessageModel JSON (request body)
	 */
	@RequestMapping(value = "/updatemessage", method = RequestMethod.PUT, consumes = "application/json")
	public void updateMessage(@RequestBody MessageModel message) 
	{
		// call updateMessage using injected dependency passing in the message
	    messageService.updateMessage(message);
	}
	/**
	 * Path: /messaging/deletemessage/{id}
	 * RequestType: DELETE
	 * Description: Will delete a message based off of ID
	 * @param id type int (path param)
	 */
	@RequestMapping(value = "/deletemessage/{id}", method = RequestMethod.DELETE)
	public void deleteMessage(@PathVariable("id") int id) 
	{
		// call deleteMessage using injected dependency passing in the ID
	    messageService.deleteMessage(id);
	}
	/**
	 * Path: /messaging/get-new-messages
	 * RequestType: GET
	 * Description: Will return any new messages posted after the most recent message loaded on the page in ASC order
	 * Produces: JSON
	 * @param index type int (query param)
	 * @return List of MessageModel JSON
	 */
	@RequestMapping(value = "/get-new-messages", method = RequestMethod.GET, produces = "application/json")
	public List<MessageModel> getNewMessages(@RequestParam(value = "index", required = true) int index)
	{
		// returning the list of MessageModels using injected dependency calling getNewMessages
		return messageService.getNewMessages(index);
	}
}
