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
public class TemplateEntity {

	private String content;
	private long id;
	private String name;
	private String type;
	private int version;
	private StatusEnum status;

}
