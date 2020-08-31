package com.eagle.mailer.entity.sequence;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "SenderSequence")
public class SenderSequenceEntity {
	@Id
	private String id;
	private BigInteger seq;

}
