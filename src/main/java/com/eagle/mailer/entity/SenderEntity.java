package com.eagle.mailer.entity;

import java.math.BigInteger;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.eagle.mailer.enums.StatusEnum;
import com.eagle.mailer.enums.AccountTypeEnum;
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
@Document(collation = "Sender")
public class SenderEntity {
	@Id
	private BigInteger id;
	private AccountTypeEnum accountType;
	private LocalDate createdDate;
	private String email;
	private String firstName;
	private String lastName;
	private MailingInfoEntity mailingInfo;
	private String password;
	private StatusEnum status;
}
