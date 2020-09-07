package com.revature.exceptions;

public class ActionNotPermittedException extends AuthorizationException {
	private static final long serialVersionUID = 6570145761960203215L;

	public ActionNotPermittedException() {
		super();
	}

	public ActionNotPermittedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ActionNotPermittedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActionNotPermittedException(String message) {
		super(message);
	}

	public ActionNotPermittedException(Throwable cause) {
		super(cause);
	}
}
