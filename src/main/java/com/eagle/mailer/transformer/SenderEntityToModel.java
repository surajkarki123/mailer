package com.eagle.mailer.transformer;

import java.util.function.Function;
import org.springframework.stereotype.Component;
import com.eagle.mailer.entity.SenderEntity;
import com.eagle.mailer.enums.AccountTypeEnum;
import com.eagle.mailer.enums.StatusEnum;
import com.eagle.mailer.modal.Sender;

@Component
public class SenderEntityToModel implements Function<SenderEntity, Sender>{

	@Override
	public Sender apply(SenderEntity senderEntity) {
		
		return Sender.builder()
				.createdDate(senderEntity.getCreatedDate())
				.email(senderEntity.getEmail())
				.firstName(senderEntity.getFirstName())
				.lastName(senderEntity.getLastName())
				.status(StatusEnum.status(senderEntity.getStatus()))
				.accountType(AccountTypeEnum.accountType(senderEntity.getAccountType()))
				.password(senderEntity.getPassword())
				.id(senderEntity.getId())
				.build();
	}

}
