package com.prateek.maxFoodSatifactionProblem.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prateek.maxFoodSatifactionProblem.service.FoodSatisfactionCalculatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@WebMvcTest({FoodSatisfactionCalculatorService.class, RestHandler.class})
public class RestHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FoodSatisfactionCalculatorService s;

    @Test
    public void testAPI() throws JsonProcessingException, Exception {

        String input = "7 4" + "\n 1 1" + "\n4 3" + "\n5 4" + "\n7  5";

        mockMvc.perform(post("/app/calculateFoodSatisfactionValue")
                .contentType(MediaType.ALL)
                .content(input)
                .accept(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Test
    public void testInValidJSON() throws JsonProcessingException, Exception {

        String input = "1 1\n 1";

        mockMvc.perform(post("/app/calculateFoodSatisfactionValue")
                .contentType(MediaType.ALL)
                .content(input)
                .accept(MediaType.ALL))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testAPIWithExceptionInputFromUser() throws JsonProcessingException, Exception {

        String input = "Test";

        mockMvc.perform(post("/app/calculateFoodSatisfactionValue")
                .contentType(MediaType.ALL)
                .content(input)
                .accept(MediaType.ALL))
                .andExpect(status().isBadRequest());
    }

}
