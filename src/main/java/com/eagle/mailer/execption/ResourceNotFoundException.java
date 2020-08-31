package com.eagle.mailer.execption;

import static com.eagle.mailer.exception.model.ErrorCode.RESOURCE_NOT_FOUND;
import com.eagle.mailer.exception.model.ErrorCode;

public class ResourceNotFoundException extends BusinessException  {
	
	private static final long serialVersionUID = -2263741288285030589L;
	private static final ErrorCode CODE = RESOURCE_NOT_FOUND;
	private static final String DEFAULT_MESSAGE = "Exception occured while calling this database exception.";

	public ResourceNotFoundException() {
		super(CODE, DEFAULT_MESSAGE);
	}

	

}
