package com.eagle.mailer.mail.service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.stereotype.Service;
import com.eagle.mailer.context.MailerContext;
import com.eagle.mailer.entity.RecipientEntity;
import com.eagle.mailer.enums.StatusEnum;
import com.eagle.mailer.execption.DataBaseException;
import com.eagle.mailer.modal.Recipient;
import com.eagle.mailer.repository.RecipientRepository;
import com.eagle.mailer.transformer.RecipientEntityToModel;
import com.eagle.mailer.transformer.RecipientModelToEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipientService {
	
	private static final String EXP_MSG = "Execption occured while performing the operation for Recipient name/Id %s for client %s";

	private final  RecipientRepository recipientRepository;
	private final  RecipientModelToEntity  recipientModelToEntity;
	private final  RecipientEntityToModel  recipientEntityToModel;
	
	
	public void delete(BigInteger id) {
		RecipientEntity recipientEntity = fetchById(id);
		
		if (Objects.nonNull(recipientEntity)) {
			recipientEntity.setStatus(StatusEnum.DELETED.code());
			process(recipientEntity);
		}
	}


	public Recipient save(Recipient recipient) {
		recipient.setId(BigInteger.valueOf(0));
		recipient.setStatus(StatusEnum.ACTIVE.name());
		return process(recipient);
	}

	public Recipient update(Recipient recipient) {
		if (Objects.nonNull(recipient.getId()) && Objects.nonNull(fetchById(recipient.getId()))) {
			process(recipient);
		}
		return recipient;
	}

	public Recipient findById(BigInteger id) {
		RecipientEntity senderEntity = fetchById(id);
		return Objects.nonNull(senderEntity) ? recipientEntityToModel.apply(senderEntity) : null;

	}
	
	private RecipientEntity fetchById(BigInteger id) {
		RecipientEntity recipientEntity = null;

		try {
			recipientEntity = recipientRepository.findByIdAndClientIdAndStatusNotIn(id, MailerContext.getClientId(),
					Arrays.asList(StatusEnum.INACTIVE.code(), StatusEnum.DELETED.code()));
		} catch (Exception exp) {
			throwException(String.valueOf(id), exp);
		}
		return Objects.nonNull(recipientEntity) ? recipientEntity : null;
	}


	private Recipient process(Recipient recipient) {
		RecipientEntity recipientEntity = process(recipientModelToEntity.apply(recipient));
		recipient.setId(recipientEntity.getId());
		return recipient;
	}

	private RecipientEntity process(RecipientEntity recipientEntity) {
		try {
			recipientEntity = recipientRepository.save(recipientEntity);
		} catch (Exception exp) {
			throwException(String.valueOf(recipientEntity.getId()), exp);
		}
		return recipientEntity;
	}

	private void throwException(String recipientId, Exception exp) {
		throw new DataBaseException(String.format(EXP_MSG, recipientId, MailerContext.getClientId()), exp);
	}

	
	

}
