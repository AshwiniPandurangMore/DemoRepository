package com.example.EComApplication.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class IdNotFoundException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotFoundException()
	{
		super();
	}
	
	public IdNotFoundException(String message)
	{
		super(message);
	}
}
