package com.eagle.mailer.transformer;

import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.eagle.mailer.context.MailerContext;
import com.eagle.mailer.entity.TemplateEntity;
import com.eagle.mailer.enums.StatusEnum;
import com.eagle.mailer.modal.Template;
import com.eagle.mailer.sequence.TemplateSequenceRepository;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class TemplateModelToEntity implements Function<Template, TemplateEntity>{

	private final TemplateSequenceRepository sequence;
	
	@Override
	public TemplateEntity apply(Template template) {
		Long id = Objects.nonNull(template.getId()) && template.getId() > 0 ? template.getId() : sequence.getNextSequence();
		
				return TemplateEntity.builder()
						.content(template.getContent())
						.name(template.getName())
						.subject(template.getSubject())
						.clientId(MailerContext.getClientId())
						.id(id)
						.status(StatusEnum.valueOf(template.getStatus()).code())
						.build();
	}
}
