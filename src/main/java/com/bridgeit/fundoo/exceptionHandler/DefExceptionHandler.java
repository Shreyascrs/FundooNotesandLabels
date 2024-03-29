package com.bridgeit.fundoo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class DefExceptionHandler extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> RuntimeException(String message) {
		return new ResponseEntity<String>("Something is not right", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> Exception(String message) {
		return new ResponseEntity<String>("Something is not right", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
