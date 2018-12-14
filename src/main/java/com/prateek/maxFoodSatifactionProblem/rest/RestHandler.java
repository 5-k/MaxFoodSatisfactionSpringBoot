package com.prateek.maxFoodSatifactionProblem.rest;

import com.prateek.maxFoodSatifactionProblem.dto.Response;
import com.prateek.maxFoodSatifactionProblem.exceptions.CustomAPIException;
import com.prateek.maxFoodSatifactionProblem.service.FoodSatisfactionCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestHandler {

    @Autowired
    private FoodSatisfactionCalculatorService foodSatisfactionCalculatorService;


    @RequestMapping(value = "/app/calculateFoodSatisfactionValue", method = RequestMethod.POST)
    public ResponseEntity<Response> getMaximumSatisFactionValue(@RequestBody String input) {

        try {
            int response = foodSatisfactionCalculatorService.maximumSatisfaction(input);
            String message = "John can a satisfaction of value " + response;
            return ResponseEntity.status(HttpStatus.OK).body(new Response(message, HttpStatus.OK.value()));
        } catch (CustomAPIException e) {
            String message = "Well john! Seems like you gave me an invalid input : " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(message, HttpStatus.BAD_REQUEST.value()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }
}
