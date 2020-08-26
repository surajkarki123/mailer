package com.eagle.mailer.service.impl;

import org.springframework.stereotype.Service;

import com.eagle.mailer.mail.properties.EmailProperties;
import com.eagle.mailer.mail.service.EmailSenderService;
import com.eagle.mailer.service.MailService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

	private static final String SUBJECT = "SSO FOR YOUR WEBSITE";
	private static final String TEMPLATE = "Hi,\n"
			+ "A few days ago I came across your website and I noticed that you were not ranking well for certain keyword phrases. I would like to send you an absolutely free Audit report showing you 3 or 4 things which can help you to improve your Google rankings dramatically. Would that be okay? I would send it to you sometime next week.\n"
			+ "Again, this is a completely free service. Please let me know.\n" + "Thanks in advance,";

	private final EmailSenderService emailSenderService;
	private final EmailProperties properties;

	@Override
	public void sendMail() {
		properties.getRecipient().stream()
				.forEach(recipient -> emailSenderService.sendEmail(recipient, SUBJECT, TEMPLATE));
	}

}
