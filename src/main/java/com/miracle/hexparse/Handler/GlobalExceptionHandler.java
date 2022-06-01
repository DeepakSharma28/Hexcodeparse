package com.miracle.hexparse.Handler;

import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;

import com.miracle.hexparse.exception.InsufficientNoOfBytesException;
import com.miracle.hexparse.exception.InvalidInputException;

import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseEntity<?> handleInsufficientNoOfBytesException(
			InsufficientNoOfBytesException insufficientNoOfBytesException, ServletWebRequest request) {
	
		return new ResponseEntity<>(insufficientNoOfBytesException.getMessage(),HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseEntity<?> handleInvalidInputException(
			InvalidInputException invalidInputException, ServletWebRequest request) {
	
		return new ResponseEntity<>(invalidInputException.getMessage(),HttpStatus.BAD_REQUEST);

	}
	
}
