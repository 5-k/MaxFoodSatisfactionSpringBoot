package com.prateek.maxFoodSatifactionProblem.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAPIException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CustomAPIException.class);
	
	public CustomAPIException(String message) {
		super(message);
		logger.error(message);
	}
	
}
