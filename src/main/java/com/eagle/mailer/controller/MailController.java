package com.eagle.mailer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.mailer.service.MailService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/mail")
@AllArgsConstructor
public class MailController {

	private final MailService mailService;

	@GetMapping("/send")
	public ResponseEntity<Void> save() {
		mailService.sendMail();
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
