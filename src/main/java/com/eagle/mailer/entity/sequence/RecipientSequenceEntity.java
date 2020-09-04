package com.eagle.mailer.entity.sequence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "RecipientSequence")
public class RecipientSequenceEntity {
	@Id
	private String id;
	private long seq;
}
