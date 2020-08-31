package com.eagle.mailer.execption;

import com.eagle.mailer.exception.model.ErrorAttribute;
import com.eagle.mailer.exception.model.ErrorCode;

import lombok.Getter;

public class BusinessException extends ApiException {

	private static final long serialVersionUID = 4151569448693017560L;

	@Getter
	private ErrorAttribute attribute;

	public BusinessException(ErrorCode code) {
		super(code);
	}

	public BusinessException(ErrorCode code, ErrorAttribute attribute) {
		super(code);
		this.attribute = attribute;
	}

	public BusinessException(ErrorCode code, Throwable cause) {
		super(code, cause);
	}

	public BusinessException(ErrorCode code, ErrorAttribute attribute, Throwable cause) {
		super(code, cause);
		this.attribute = attribute;
		this.code = code;
	}

	public BusinessException(ErrorCode code, String message) {
		super(code, message);
	}
}