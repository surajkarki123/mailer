package com.eagle.mailer.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Template {

	private long id;
	private String content;
	private String subject;
	private String name;
	private String type;
	private String status;

}
