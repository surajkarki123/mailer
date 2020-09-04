package com.eagle.mailer.transformer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.eagle.mailer.entity.RecipientEntity;
import com.eagle.mailer.enums.StatusEnum;
import com.eagle.mailer.modal.Recipient;

@Component
public class RecipientEntityToModel  implements Function<RecipientEntity, Recipient>{

	@Override
	public Recipient apply(RecipientEntity recipientEntity) {
		
		return Recipient.builder()
				.email(recipientEntity.getEmail())
				.firstName(recipientEntity.getFirstName())
				.lastName(recipientEntity.getLastName())
				.id(recipientEntity.getId())
				.status(StatusEnum.status(recipientEntity.getStatus()))
				.build();
	}

}
