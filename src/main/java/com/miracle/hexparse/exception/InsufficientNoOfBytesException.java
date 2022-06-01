package com.miracle.hexparse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InsufficientNoOfBytesException extends RuntimeException {

	private static final long serialVersionUID = 1974338360847342786L;

	public InsufficientNoOfBytesException(String key) {
		super("Insufficient no of bytes provided for the given key - "+key);
	}
}