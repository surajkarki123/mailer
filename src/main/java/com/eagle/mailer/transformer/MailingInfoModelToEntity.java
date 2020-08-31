package com.eagle.mailer.transformer;

import java.util.Objects;
import org.springframework.stereotype.Component;
import com.eagle.mailer.entity.MailingInfoEntity;
import com.eagle.mailer.modal.MailingInfo;
import com.eagle.mailer.sequence.MailingInfoSequenceRepository;
import com.google.common.base.Function;
import lombok.AllArgsConstructor;



public class MailingInfoModelToEntity implements Function<MailingInfo, MailingInfoEntity>{

	@Override
	public MailingInfoEntity apply(MailingInfo input) {
		// TODO Auto-generated method stub
		return null;
	}
     
	//private final MailingInfoSequenceRepository sequence; 
	
//	@Override
//	public MailingInfoEntity apply(MailingInfo input) {
//		int id = Objects.nonNull(input.getTemplateId()) ? input.getTemplateId() : sequence.getNextSequence();
//		
////		return MailingInfoEntity.builder()
////				.clientId(input.getClientId())
////				.templateId(id)
////				.templateType(input.getTemplateType())
////				.lastMailSent(input.getLastMailSent())
////				.build();
////	}

}
