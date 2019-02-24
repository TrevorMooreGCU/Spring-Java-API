package com.gcucloud.services.data;

import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.gcucloud.model.MessageModel;

/**
 * Trevor Moore
 * CST-323
 * 02/14/2019
 * This assignment was completed in collaboration with Connor Low
 * This is our own work.
 * 
 * MessageDAO class for accessing and returning data from the database. Implements MessageDAO.
 * @author Trevor
 *
 */
public class MessageDAO implements IMessageDAO<MessageModel>
{
	// Injecting DataSource and JdbcTemplate
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	/**
	 * Autowired method for setting the DataSource and JdbcTemplate in order to connect to the db
	 * @param dataSource type DataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/**
	 * (OVERLOADED METHOD)
	 * Method for creating a new message with a defined sender
	 * 
	 * @param message of type MessageModel
	 */
	public void addMessage(MessageModel message) 
	{
		// defining the insert sql statement with sender
		String query = "INSERT INTO hakd3acwmr7ozvcq.MESSAGE (MESSAGEBODY, CREATIONDATE, SENDER) VALUES (?, ?, ?)";
		// execute the update
		jdbcTemplate.update(query, message.getMessagebody(), message.getCreationdate(), message.getSender());
	}
	/**
	 * (OVERLOADED METHOD)
	 * Method for creating a new message with an anonymous sender
	 * 
	 * @param message of type MessageModel
	 */
	public void addMessage(String messageBody, String creationDate) 
	{
		// defining the insert sql statement with no sender
		String query = "INSERT INTO hakd3acwmr7ozvcq.MESSAGE (MESSAGEBODY, CREATIONDATE) VALUES (?, ?)";
		// execute the update
		jdbcTemplate.update(query, messageBody, creationDate);
	}
	/**
	 * Method for deleting a message
	 * 
	 * @param id type int
	 */
	public void deleteMessage(int id) 
	{
		// defining the delete sql statement
		String query = "DELETE FROM hakd3acwmr7ozvcq.MESSAGE WHERE ID = ?";
		// execute the update
		jdbcTemplate.update(query, id);
	}
	/**
	 * Method for updating a message
	 * 
	 * @param message type MessageModel
	 */
	public void updateMessage(MessageModel message) 
	{
		// defining the update sql statement
		String query = "UPDATE hakd3acwmr7ozvcq.MESSAGE SET MESSAGEBODY = ? WHERE ID = ?";
		// execute the update
		jdbcTemplate.update(query, message.getMessagebody(), message.getId());
	}
	/**
	 * Method for getting all the messages
	 * 
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getAll() 
	{
		// defining the select sql statement
		String query = "SELECT * FROM hakd3acwmr7ozvcq.MESSAGE ORDER BY ID DESC";
		// execute the query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query);
		// instantiate list of message models
		List<MessageModel> messages = new ArrayList<MessageModel>();
		// while the rowset has a next add the row to the list
	    while(srs.next())
	    	messages.add(new MessageModel(srs.getString("ID"), srs.getString("MESSAGEBODY"), srs.getString("CREATIONDATE"), srs.getString("SENDER")));
	    // return the list
	    return messages;
	}
	/**
	 * (OVERLOADED METHOD)
	 * Method for getting a specific number of messages including and after the most recent message
	 * 
	 * @param requestedNumberOfMessages type int
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getMessages(int requestedNumberOfMessages) 
	{
		// defining the select sql statement
		String query = "SELECT * FROM hakd3acwmr7ozvcq.MESSAGE ORDER BY ID DESC LIMIT ?";
		// execute the query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, requestedNumberOfMessages);
		// instantiate list of message models
		List<MessageModel> messages = new ArrayList<MessageModel>();
		// while the rowset has a next add the row to the list
	    while(srs.next())
	    	messages.add(new MessageModel(srs.getString("ID"), srs.getString("MESSAGEBODY"), srs.getString("CREATIONDATE"), srs.getString("SENDER")));
	    // return the list
	    return messages;
	}
	/**
	 * (OVERLOADED METHOD)
	 * Method for getting a specific number of messages after the given current message ID
	 * 
	 * @param currentMessageID type int
	 * @param requestedNumberOfFollowingMessages type int
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getMessages(int currentMessageID, int requestedNumberOfFollowingMessages) 
	{
		// defining the select sql statement
		String query = "SELECT * FROM hakd3acwmr7ozvcq.MESSAGE WHERE ID < ? ORDER BY ID DESC LIMIT ?";
		// execute the query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, currentMessageID, requestedNumberOfFollowingMessages);
		// instantiate list of message models
		List<MessageModel> messages = new ArrayList<MessageModel>();
		// while the rowset has a next add the row to the list
	    while(srs.next())
	    	messages.add(new MessageModel(srs.getString("ID"), srs.getString("MESSAGEBODY"), srs.getString("CREATIONDATE"), srs.getString("SENDER")));
	    // return the list
	    return messages;
	}
	/**
	 * Method for loading newer messages than the most recent one loaded on the page
	 * 
	 * @param mostRecentLoadedMessageID type int
	 * @return type ListMessageModel
	 */
	public List<MessageModel> getNewMessages(int mostRecentLoadedMessageID)
	{
		// defining the select sql statement
		String query = "SELECT * FROM hakd3acwmr7ozvcq.MESSAGE WHERE ID > ? ORDER BY ID ASC";
		// execute the query
		SqlRowSet srs = jdbcTemplate.queryForRowSet(query, mostRecentLoadedMessageID);
		// instantiate list of message models
		List<MessageModel> messages = new ArrayList<MessageModel>();
		// while the rowset has a next add the row to the list
	    while(srs.next())
	    	messages.add(new MessageModel(srs.getString("ID"), srs.getString("MESSAGEBODY"), srs.getString("CREATIONDATE"), srs.getString("SENDER")));
	    // return the list
	    return messages;
	}
}
