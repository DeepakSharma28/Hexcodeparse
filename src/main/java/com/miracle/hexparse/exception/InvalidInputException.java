package com.miracle.hexparse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException {
	private static final long serialVersionUID = 1974338360847342787L;

	public InvalidInputException() {
		super("Invalid Input Given");
	}
}
