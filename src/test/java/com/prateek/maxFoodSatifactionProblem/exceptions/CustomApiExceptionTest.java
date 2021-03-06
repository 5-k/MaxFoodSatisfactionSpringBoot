package com.prateek.maxFoodSatifactionProblem.exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;


import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomApiExceptionTest {

	@InjectMocks
	private CustomAPIException customApiException;

	@Test
	public void testInstance() {
		Assert.assertTrue(customApiException instanceof RuntimeException);
	}

	@Test
	public void testValue() {
		customApiException = new CustomAPIException("Test");
		System.out.println(customApiException.getMessage().equals("Test"));
	}
}
