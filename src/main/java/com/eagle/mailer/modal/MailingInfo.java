package com.eagle.mailer.modal;

import java.time.LocalDate;

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
public class MailingInfo {

	private int templateId;
	private LocalDate lastMailSent;
	private String templateType;
	private String clientId;
}
