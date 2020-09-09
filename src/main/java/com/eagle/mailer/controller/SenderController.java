package com.eagle.mailer.controller;

import static com.eagle.mailer.constants.MailerConstants.Endpoints.SENDER_END_POINT;

import java.math.BigInteger;
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
	public ResponseEntity<Boolean> delete(@PathVariable("id") BigInteger id) {
		senderService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sender> get(@PathVariable("id") BigInteger id) {
		return ResponseEntity.ok(senderService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Sender> save(@RequestBody Sender sender) {
		return ResponseEntity.ok(senderService.save(sender));
	}

	@PutMapping
	public ResponseEntity<Sender> update(@RequestBody Sender sender) {
		return ResponseEntity.ok(senderService.update(sender));
	}

}
