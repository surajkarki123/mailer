package com.eagle.mailer.mail.service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.eagle.mailer.context.MailerContext;
import com.eagle.mailer.entity.SenderEntity;
import com.eagle.mailer.enums.StatusEnum;
import com.eagle.mailer.execption.DataBaseException;
import com.eagle.mailer.modal.Sender;
import com.eagle.mailer.repository.SenderRepository;
import com.eagle.mailer.transformer.SenderEntityToModel;
import com.eagle.mailer.transformer.SenderModelToEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SenderService {

	private static final String EXP_MSG = "Execption occured while performing the operation for Sender name/Id %s for client %s";

	private final SenderRepository senderRepository;
	private final SenderModelToEntity senderModelToEntity;
	private final SenderEntityToModel senderEntityToModel;

	public void delete(BigInteger id) {
		SenderEntity senderEntity = fetchById(id);

		if (Objects.nonNull(senderEntity)) {
			senderEntity.setStatus(StatusEnum.DELETED.code());
			process(senderEntity);
		}
	}

	public Sender save(Sender sender) {
		sender.setId(BigInteger.valueOf(0));
		return process(sender);
	}

	public Sender update(Sender sender) {
		if (Objects.nonNull(sender.getId()) && Objects.nonNull(fetchById(sender.getId()))) {
			process(sender);
		}
		return sender;
	}

	public Sender findById(BigInteger id) {
		SenderEntity senderEntity = fetchById(id);
		return Objects.nonNull(senderEntity) ? senderEntityToModel.apply(senderEntity) : null;

	}

	private SenderEntity fetchById(BigInteger id) {
		SenderEntity sender = null;

		try {
			sender = senderRepository.findByIdAndClientIdAndStatusNotIn(id, MailerContext.getClientId(),
					Arrays.asList(StatusEnum.INACTIVE.code(), StatusEnum.DELETED.code()));
		} catch (Exception exp) {
			throwException(String.valueOf(id), exp);
		}
		return Objects.nonNull(sender) ? sender : null;
	}

	private Sender process(Sender sender) {
		SenderEntity senderEntity = process(senderModelToEntity.apply(sender));
		sender.setId(senderEntity.getId());
		return sender;
	}

	private SenderEntity process(SenderEntity senderEntity) {
		try {
			senderEntity = senderRepository.save(senderEntity);
		} catch (Exception exp) {
			throwException(String.valueOf(senderEntity.getId()), exp);
		}
		return senderEntity;
	}

	private void throwException(String senderId, Exception exp) {
		throw new DataBaseException(String.format(EXP_MSG, senderId, MailerContext.getClientId()), exp);
	}
}
