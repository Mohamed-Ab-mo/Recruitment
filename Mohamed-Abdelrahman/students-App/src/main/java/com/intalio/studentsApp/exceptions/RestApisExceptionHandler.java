package com.intalio.studentsApp.exceptions;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestApisExceptionHandler {
	
	@ExceptionHandler(RestApisException.class)
    protected RestApisExceptionResponse handleApisException(RestApisException exception) {
		return new RestApisExceptionResponse(exception.getStatus(), exception.getMessage(), LocalTime.now());    
	}

}
