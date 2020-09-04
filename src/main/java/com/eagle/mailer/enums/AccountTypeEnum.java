package com.eagle.mailer.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AccountTypeEnum {

	NEW1(1), OLD(2);

	private int code;

	private AccountTypeEnum(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}
	
	public static String accountType(int code) {
		Optional<AccountTypeEnum> accuntTypeOptional = Arrays.asList(AccountTypeEnum.values()).stream().filter(ac-> ac.code==code).findFirst();
		return accuntTypeOptional.isPresent()? accuntTypeOptional.get().name(): "";
		
	}

}
