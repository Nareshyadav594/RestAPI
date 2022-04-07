package com.javaexpress.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(BookNotFoundException ex) {
		List<String> details=new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), "client error", details);
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorDetails> handleException(Exception ex) {
		List<String> details=new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), "server error", details);
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
}
