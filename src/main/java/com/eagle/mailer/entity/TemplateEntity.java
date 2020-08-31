package com.eagle.mailer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "Template")
public class TemplateEntity {

	@Id
	private long id;
	private String content;
	private String subject;
	private String name;
	private String type;
	private int version;
	private String clientId;
	private int status;

}
