package com.eagle.mailer.enums;

import java.util.Arrays;
import java.util.Optional;

public enum StatusEnum {

	ACTIVE(1), INACTIVE(0), DELETED(-1);

	private int code;

	private StatusEnum(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

	public static String status(int code) {
		Optional<StatusEnum> statusOptional = Arrays.asList(StatusEnum.values()).stream()
				.filter(se -> se.code() == code).findFirst();
		return statusOptional.isPresent() ? statusOptional.get().name() : "";
	}

}
