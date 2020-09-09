package com.eagle.mailer.transformer;

import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.eagle.mailer.context.MailerContext;
import com.eagle.mailer.entity.RecipientEntity;
import com.eagle.mailer.enums.StatusEnum;
import com.eagle.mailer.modal.Recipient;
import com.eagle.mailer.sequence.RecipientSequenceRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RecipientModelToEntity implements Function<Recipient, RecipientEntity>{
	
	private final RecipientSequenceRepository  sequence;

	@Override
	public RecipientEntity apply(Recipient recipient) {
		BigInteger id = Objects.nonNull(recipient.getId()) && recipient.getId().compareTo(BigInteger.ZERO)>0 ? recipient.getId() : sequence.getNextSequence();

		return RecipientEntity.builder()
				.id(id)
				.firstName(recipient.getFirstName())
				.lastName(recipient.getLastName())
				.email(recipient.getEmail())
				.status(StatusEnum.valueOf(recipient.getStatus()).code())
				.clientId(MailerContext.getClientId())
				.build();
	}

}
