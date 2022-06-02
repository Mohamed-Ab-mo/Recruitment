package com.intalio.studentsApp.exceptions;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;

public class RestApisExceptionResponse {
	
	private  HttpStatus status;
    private  String message;
    private  LocalTime timesTamp;

    public RestApisExceptionResponse(HttpStatus status, String message, LocalTime timesTamp) {
        this.status= status;
        this.message = message;
        this.timesTamp = timesTamp;
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalTime getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(LocalTime timesTamp) {
		this.timesTamp = timesTamp;
	}
   

}
