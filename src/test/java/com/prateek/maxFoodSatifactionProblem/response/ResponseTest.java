package com.prateek.maxFoodSatifactionProblem.response;

import com.prateek.maxFoodSatifactionProblem.dto.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResponseTest {

	@Test
	public void testSetAndGetMessageWithConstructor() {
		Response response = new Response("Test Response", 200);
		Assert.assertTrue(response.getResponseMessage().equals("Test Response"));
		Assert.assertTrue(response.getStatusCode() == 200);
	}

	@Test
	public void testSetAndGetMessage() {
		Response response = new Response("Test Response", 200);
		Assert.assertTrue(response.getResponseMessage().equals("Test Response"));
		Assert.assertTrue(response.getStatusCode() == 200);

		response.setResponseMessage("Test Message");
		response.setStatusCode(400);
		Assert.assertTrue(response.getResponseMessage().equals("Test Message"));
		Assert.assertTrue(response.getStatusCode() == 400);

	}
}
