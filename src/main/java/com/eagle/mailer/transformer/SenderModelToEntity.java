package com.eagle.mailer.transformer;

import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.eagle.mailer.context.MailerContext;
import com.eagle.mailer.entity.SenderEntity;
import com.eagle.mailer.enums.AccountTypeEnum;
import com.eagle.mailer.enums.StatusEnum;
import com.eagle.mailer.modal.Sender;
import com.eagle.mailer.sequence.SenderSequenceRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SenderModelToEntity  implements Function<Sender, SenderEntity>{
	
	private final SenderSequenceRepository sequence;
	
	@Override
	public SenderEntity apply(Sender sender) {
		BigInteger id = Objects.nonNull(sender.getId()) && sender.getId().compareTo(BigInteger.ZERO) > 0 ? sender.getId()  : sequence.getNextSequence();
		
		return SenderEntity.builder()
				.clientId(MailerContext.getClientId())
				.email(sender.getEmail())
				.firstName(sender.getFirstName())
				.createdDate(sender.getCreatedDate())
				.password(sender.getPassword())
				.id(id)
				.status(StatusEnum.valueOf(sender.getStatus()).code())
				.accountType(AccountTypeEnum.valueOf(sender.getAccountType()).code())
				.build();
	}

}
