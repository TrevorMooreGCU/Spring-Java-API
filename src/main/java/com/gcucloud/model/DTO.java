package com.gcucloud.model;

import java.util.List;

/**
 * Trevor Moore
 * CST-323
 * 03/12/2019
 * This assignment was completed in collaboration with Connor Low
 * This is our own work.
 * 
 * DTO class to carry and encapsulate data returned from the Messaging API endpoints.
 * @author Trevor
 *
 */
public class DTO 
{
	public int errorCode;
	public String errorMsg;
	public List<MessageModel> data;
	/**
	 * Default constructor
	 */
	public DTO()
	{
		this.errorCode = 500;
		this.errorMsg = "Internal Server Error.";
		this.data = null;
	}
	/**
	 * Non-default constructor
	 * @param errorCode type int
	 * @param errorMsg type String
	 * @param data type List of MessageModel
	 */
	public DTO(int errorCode, String errorMsg, List<MessageModel> data)
	{
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	/// GETTERS AND SETTERS ///
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public List<MessageModel> getData() {
		return data;
	}
	public void setData(List<MessageModel> data) {
		this.data = data;
	}
}
