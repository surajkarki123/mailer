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
public class Sender {

	private long id;
	private String accountType;
	private LocalDate createdDate;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String status;
	private String clientId;
}
