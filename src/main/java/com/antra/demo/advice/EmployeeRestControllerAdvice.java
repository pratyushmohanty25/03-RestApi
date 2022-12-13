package com.antra.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.antra.demo.Exception.EmployeeNotFoundException;
import com.antra.demo.model.ErrMessage;

@RestControllerAdvice
public class EmployeeRestControllerAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrMessage> exHandelller(EmployeeNotFoundException e){
		ErrMessage errMessage=new ErrMessage();
		errMessage.setMessage(e.getMessage());
		return new ResponseEntity<ErrMessage>(errMessage,HttpStatus.BAD_REQUEST);	
	}
}
