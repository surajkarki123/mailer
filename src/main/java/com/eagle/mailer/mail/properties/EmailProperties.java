package com.eagle.mailer.mail.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@ConfigurationProperties(prefix = "spring.mail.sender")
public class EmailProperties {

	private String host;

	private String password;

	private Integer port;

	@Value("#{'${spring.mail.sender.recipients}'.split(',')}")
	private List<String> recipient;

	private String sender;

	private String senderName;

	private String username;
}
