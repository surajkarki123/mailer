package com.eagle.mailer.mail.service;

import org.springframework.stereotype.Service;

import com.eagle.mailer.modal.Sender;

@Service
public class SenderService {

	public boolean delete(long id) {
		return true;
	}

	public Sender get(long id) {
		return null;
	}

	public Sender save(Sender sender) {
		return sender;
	}

	public Sender update(Sender sender) {
		return sender;
	}
}
