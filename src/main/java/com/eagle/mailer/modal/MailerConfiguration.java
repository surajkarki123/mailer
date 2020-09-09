package com.eagle.mailer.modal;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailerConfiguration {

	private String clientId;
	private long templateId;
	private long totalSender;
	private long mailPerDay;
	private int newAccountLimit;
	private int oldAccountLimit;
	private LocalDateTime schedulerTimeForMail;
	private LocalDateTime schedulerTimeForMailReceiving;
	private int reusableSender;
	private int reusableRecipient;
}
