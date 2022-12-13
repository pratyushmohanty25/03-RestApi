package com.antra.demo.Exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(){
		
	}
	
	public EmployeeNotFoundException(String message){
		super(message);
	}

}
