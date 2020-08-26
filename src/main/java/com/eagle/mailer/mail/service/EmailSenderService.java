package com.eagle.mailer.mail.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.eagle.mailer.mail.sender.EmailSender;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class EmailSenderService {

	private EmailSender emailSender;

	@Async
	public void sendEmail(String recipient, String subject, String content) {
		try {
			emailSender.sendSimpleMessage(recipient, subject, content);
			log.info(String.format("Email sent successfully to %s at %s.", recipient, LocalDateTime.now()));
		} catch (Exception exp) {
			log.error("Exception occurred while sending mail to " + recipient, exp);
		}
	}
}
