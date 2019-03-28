package com.gcucloud.services.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gcucloud.model.DTO;
import com.gcucloud.model.MessageModel;
import com.gcucloud.services.business.IMessageService;

/**
 * Trevor Moore
 * CST-323
 * 03/12/2019
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
	 * @return DTO JSON
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
	public DTO getAll()
	{
		// surround business service call with try/catch block
		try 
		{
			// returning the list of MessageModels using injected dependency calling getAll
			return new DTO(200, "Successfully returned all messages.", messageService.getAll());
		}
		catch(Exception e)
		{
			// returning the appropriate error code and error message if there was an exception
			return new DTO(500, "Internal Server Error.", null);
		}
	}
	/**
	 * Path: /messaging/getmessages
	 * RequestType: GET
	 * Description: Will return "count" amount of messages after the given "index"
	 * Produces: JSON
	 * @param index type int (query param)
	 * @param count type int (query param)
	 * @return DTO JSON
	 */
	@RequestMapping(value = "/getmessages", method = RequestMethod.GET, produces = "application/json")
	public DTO getMessages(@RequestParam(value = "index", required = true) int index, 
			@RequestParam(value = "count", required = true) int count)
	{
		// surround business service call with try/catch block
		try
		{
			// returning the list of MessageModels using injected dependency calling getMessages
			return new DTO(200, "Successfully returned " + count + " messages, starting at index " + index + ".", messageService.getMessages(index, count));
		}
		catch(Exception e)
		{
			// returning the appropriate error code and error message if there was an exception
			return new DTO(500, "Internal Server Error.", null);
		}
	}
	/**
	 * Path: /messaging/sendmessage
	 * RequestType: POST
	 * Description: Will send a message
	 * Consumes: JSON
	 * Produces: JSON
	 * @param message type MessageModel JSON (request body)
	 * @return DTO JSON
	 */
	@RequestMapping(value = "/sendmessage", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public DTO sendMessage(@RequestBody MessageModel message) 
	{
		// surround business service call with try/catch block
		try
		{
			// call addMessage using injected dependency passing in the message
		    messageService.addMessage(message);
		    // return appropriate error code and message upon successful completion
		    return new DTO(200, "Successfully added message sent by " + message.getSender() + ".", null);
		}
		catch(Exception e)
		{
			// returning the appropriate error code and error message if there was an exception
			return new DTO(500, "Internal Server Error.", null);
		}
	}
	/**
	 * Path: /messaging/updatemessage
	 * RequestType: PUT
	 * Description: Will update a message based off of ID
	 * Consumes: JSON
	 * Produces: JSON
	 * @param message type MessageModel JSON (request body)
	 * @return DTO JSON
	 */
	@RequestMapping(value = "/updatemessage", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public DTO updateMessage(@RequestBody MessageModel message) 
	{
		// surround business service call with try/catch block
		try
		{
			// call updateMessage using injected dependency passing in the message
		    messageService.updateMessage(message);
		    // return appropriate error code and message upon successful completion
		    return new DTO(200, "Successfully updated message that was sent on " + message.getCreationdate() + ".", null);
		}
		catch(Exception e)
		{
			// returning the appropriate error code and error message if there was an exception
			return new DTO(500, "Internal Server Error.", null);
		}
	}
	/**
	 * Path: /messaging/deletemessage/{id}
	 * RequestType: DELETE
	 * Description: Will delete a message based off of ID
	 * Produces: JSON
	 * @param id type int (path param)
	 * @return DTO JSON
	 */
	@RequestMapping(value = "/deletemessage/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public DTO deleteMessage(@PathVariable("id") int id) 
	{
		// surround business service call with try/catch block
		try
		{
			// call deleteMessage using injected dependency passing in the ID
		    messageService.deleteMessage(id);
		    // return appropriate error code and message upon successful completion
		    return new DTO(200, "Successfully deleted message id " + id + ".", null);
		}
		catch(Exception e)
		{
			// returning the appropriate error code and error message if there was an exception
			return new DTO(500, "Internal Server Error.", null);
		}
	}
	/**
	 * Path: /messaging/get-new-messages
	 * RequestType: GET
	 * Description: Will return any new messages posted after the most recent message loaded on the page in ASC order
	 * Produces: JSON
	 * @param index type int (query param)
	 * @return DTO JSON
	 */
	@RequestMapping(value = "/get-new-messages", method = RequestMethod.GET, produces = "application/json")
	public DTO getNewMessages(@RequestParam(value = "index", required = true) int index)
	{
		// surround business service call with try/catch block
		try
		{
			// returning the list of MessageModels using injected dependency calling getNewMessages
			return new DTO(200, "Successfully retrieved the newest messages past index " + index + ".", messageService.getNewMessages(index));
		}
		catch(Exception e)
		{
			// returning the appropriate error code and error message if there was an exception
			return new DTO(500, "Internal Server Error.", null);
		}
	}
}
