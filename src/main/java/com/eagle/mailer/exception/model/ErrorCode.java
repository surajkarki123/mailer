package com.eagle.mailer.exception.model;

public enum ErrorCode {

	SYSTEM_EXCEPTION("MS-500"),
	DATABASE_EXCEPTION("HIS-503"),
	BUSINESS_EXCEPTION("MS-422"),
	BAD_REQUEST("MS-400"),
	RESOURCE_NOT_FOUND("MS-1001"),
	FIELD_REQUIRED("MS-1002"),
	TEMPLATE_ID_NOT_AVAILABLE("MS-1003");
	

	private final String code;

	ErrorCode(String code) {
		this.code = code;
	}

	public String code() {
		return this.code;
	}

}
