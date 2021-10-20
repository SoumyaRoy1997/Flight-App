package com.mindtree.FlightApp.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.FlightApp.exception.ControllerException;
import com.mindtree.FlightApp.response.FlightAppResponse;





@RestControllerAdvice
public class FlightAppExceptionHandler {
	 @ExceptionHandler({ControllerException.class})
	    public ResponseEntity<FlightAppResponse> Invalid(ControllerException ex){
		System.out.println(ex.getMessage());
		FlightAppResponse response = new FlightAppResponse(ex.getMessage(),200);		    
	        return new ResponseEntity<FlightAppResponse>(
	           response,HttpStatus.OK);
	    }


}
