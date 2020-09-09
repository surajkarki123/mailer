package com.eagle.mailer.controller;

import static com.eagle.mailer.constants.MailerConstants.Endpoints.RECEIVER_END_POINT;
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
import com.eagle.mailer.mail.service.ReceiverService;
import com.eagle.mailer.modal.Receiver;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(RECEIVER_END_POINT)
@AllArgsConstructor
public class ReceiverController {
	
	private final ReceiverService receiverService;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") BigInteger id) {
		receiverService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Receiver> get(@PathVariable("id") BigInteger id) {
		return ResponseEntity.ok(receiverService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Receiver> save(@RequestBody Receiver receiver) {
		return ResponseEntity.ok().body(receiverService.save(receiver));
	}

	@PutMapping
	public ResponseEntity<Receiver> update(@RequestBody Receiver receiver) {
		return ResponseEntity.ok().body(receiverService.update(receiver));
	}

}
