package com.eagle.mailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = { "com.eagle.mailer" })
@EnableWebMvc
@EnableSwagger2
@EnableAutoConfiguration
public class MailerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailerApplication.class, args);
	}

}
