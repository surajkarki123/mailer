package com.eagle.mailer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.mailer.modal.BulkSenders;
import com.eagle.mailer.modal.Sender;
import com.eagle.mailer.modal.Template;

@RestController
@RequestMapping

public class SenderBulkController {
	
	@PostMapping
	public ResponseEntity<BulkSenders> save(@RequestBody BulkSenders bulkSenders) {
		
		 return null;
	}

}
