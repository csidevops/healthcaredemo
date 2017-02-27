package com.neu.Rohit.Exception;

public class AddException extends Exception
{
	public AddException(String message)
	{
		super(message);
	}
	
	public AddException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
