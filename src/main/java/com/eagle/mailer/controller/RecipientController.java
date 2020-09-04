package com.eagle.mailer.controller;

import java.math.BigInteger;
import static com.eagle.mailer.constants.MailerConstants.Endpoints.RECIPIENT_END_POINT;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eagle.mailer.mail.service.RecipientService;
import com.eagle.mailer.modal.Recipient;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(RECIPIENT_END_POINT)
@AllArgsConstructor
public class RecipientController {
	
	private final RecipientService recipientService;

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") BigInteger id) {
		recipientService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Recipient> get(@PathVariable("id") BigInteger id) {
		return ResponseEntity.ok(recipientService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Recipient> save(@RequestBody Recipient recipient) {
		return ResponseEntity.ok().body(recipientService.save(recipient));
	}

	@PutMapping
	public ResponseEntity<Recipient> update(@RequestBody Recipient recipient) {
		return ResponseEntity.ok().body(recipientService.update(recipient));
	}


}
