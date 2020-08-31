package com.eagle.mailer.entity.sequence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collation = "MailingInfoSequnce")
public class MailingInfoSequnceEntity {
	
	@Id
	private String id;
	private int seq;

}