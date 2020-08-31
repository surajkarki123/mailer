package com.eagle.mailer.execption;

import static com.eagle.mailer.exception.model.ErrorCode.TEMPLATE_ID_NOT_AVAILABLE;

import com.eagle.mailer.exception.model.ErrorCode;

public class TemplateIdNotAvailableException extends BusinessException {

	private static final long serialVersionUID = -7919264550439182363L;
	private static final ErrorCode CODE = TEMPLATE_ID_NOT_AVAILABLE;

	private static final String DEFAULT_MSG = "Health id not Avilable.";

	public TemplateIdNotAvailableException() {
		super(CODE, DEFAULT_MSG);

	}

	public TemplateIdNotAvailableException(String message) {
		super(CODE, message);
	}

}
