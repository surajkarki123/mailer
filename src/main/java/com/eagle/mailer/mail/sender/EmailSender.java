package com.eagle.mailer.mail.sender;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.eagle.mailer.mail.properties.EmailProperties;

@Component
public class EmailSender {

	@Autowired
	private EmailProperties properties;

	@Resource(name = "mailSession")
	private Session session;

	public void sendSimpleMessage(String recipient, String subject, String content)
			throws MessagingException, UnsupportedEncodingException {

		Transport transport = null;
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(properties.getSender(), properties.getSenderName()));
			message.setSubject(subject);
			message.setContent(content, "text/html");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			transport = session.getTransport();
			transport.connect(properties.getHost(), properties.getUsername(), properties.getPassword());
			transport.sendMessage(message, message.getAllRecipients());
		} finally {
			if (!ObjectUtils.isEmpty(transport)) {
				transport.close();
			}
		}
	}
}
