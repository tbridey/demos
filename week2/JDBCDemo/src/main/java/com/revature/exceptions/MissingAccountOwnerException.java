package com.revature.exceptions;

public class MissingAccountOwnerException extends RuntimeException {

	public MissingAccountOwnerException() {
		super();
	}

	public MissingAccountOwnerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MissingAccountOwnerException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingAccountOwnerException(String message) {
		super(message);
	}

	public MissingAccountOwnerException(Throwable cause) {
		super(cause);
	}
}
