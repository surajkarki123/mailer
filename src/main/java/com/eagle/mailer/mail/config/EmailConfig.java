package com.eagle.mailer.mail.config;

import java.util.Properties;

import javax.mail.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eagle.mailer.mail.properties.EmailProperties;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class EmailConfig {

	private final EmailProperties properties;

	@Bean("mailSession")
	public Session getJavaMailSender() {
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "false");
		props.put("mail.smtp.port", properties.getPort());

		return Session.getDefaultInstance(props);
	}
}
