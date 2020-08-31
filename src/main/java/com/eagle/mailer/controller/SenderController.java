package com.eagle.mailer.controller;

import static com.eagle.mailer.constants.MailerConstants.Endpoints.SENDER_END_POINT;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.mailer.mail.service.SenderService;
import com.eagle.mailer.modal.Sender;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(SENDER_END_POINT)
@AllArgsConstructor
public class SenderController {

	private final SenderService senderService;

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		return ResponseEntity.ok().body(senderService.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sender> get(@PathVariable("id") long id) {
		return ResponseEntity.ok().body(senderService.get(id));
	}

	@PostMapping
	public ResponseEntity<Sender> save(@RequestBody Sender sender) {
		return ResponseEntity.ok().body(senderService.save(sender));
	}

	@PutMapping
	public ResponseEntity<Sender> update(@RequestBody Sender sender) {
		return ResponseEntity.ok().body(senderService.save(sender));
	}

}
