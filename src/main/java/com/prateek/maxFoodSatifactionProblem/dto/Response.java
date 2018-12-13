package com.prateek.maxFoodSatifactionProblem.dto;

import java.io.Serializable;

/**
 * 
 * @author prateek
 */

public class Response implements Serializable {

	private static final long serialVersionUID = 2850837209871845250L;

	private String responseMessage;
	private Integer statusCode;

	public Response(String responseMessage, Integer statusCode) {
		this.responseMessage = responseMessage;
		this.statusCode = statusCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
