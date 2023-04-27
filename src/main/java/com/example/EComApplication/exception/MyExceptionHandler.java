package com.example.EComApplication.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler 
{
	@ExceptionHandler(value = IdNotFoundException.class)

	public ResponseEntity<Object> exception(IdNotFoundException exception) 
	{
		
		return null;
	}
}
