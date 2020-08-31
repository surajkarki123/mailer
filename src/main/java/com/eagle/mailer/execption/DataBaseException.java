package com.eagle.mailer.execption;

import static com.eagle.mailer.exception.model.ErrorCode.DATABASE_EXCEPTION;

import com.eagle.mailer.exception.model.ErrorCode;

public class DataBaseException extends ApiException{

	private static final long serialVersionUID = 3209861816167879375L;
	private static final ErrorCode CODE = DATABASE_EXCEPTION;
	private static final String DEFAULT_MESSAGE = "Exception occured while calling this database exception.";

	public DataBaseException() {
		super(CODE, DEFAULT_MESSAGE);
	}

	public DataBaseException(Throwable cause) {
		super(CODE, DEFAULT_MESSAGE, cause);
	}

	public DataBaseException(String message, Throwable cause) {
		super(CODE, message, cause);
	}

	public DataBaseException(String message) {
		super(CODE, message);
	}
}
