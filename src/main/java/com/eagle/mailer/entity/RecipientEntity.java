package com.eagle.mailer.entity;

import java.math.BigInteger;
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
@Document(collection  = "Recipient")
public class RecipientEntity {
	
	@Id
	private BigInteger id;
	private String email;
	private String firstName;
	private String lastName;
	private MailingInfoEntity mailingInfo;
	private int status;
	private String clientId;
}
