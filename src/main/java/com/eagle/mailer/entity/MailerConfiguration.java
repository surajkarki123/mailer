package com.eagle.mailer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailerConfiguration {
	
	

}
