package com.eagle.mailer.entity;

import com.eagle.mailer.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipientEntity {

	private String email;
	private String firstName;
	private long id;
	private String lastName;
	private MailingInfoEntity mailingInfo;
	private StatusEnum status;
}
