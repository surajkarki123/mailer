package com.eagle.mailer.transformer;

import java.util.function.Function;
import org.springframework.stereotype.Component;
import com.eagle.mailer.entity.TemplateEntity;
import com.eagle.mailer.modal.Template;

@Component
public class TemplateEntityToModel implements Function<TemplateEntity, Template> {

	@Override
	public Template apply(TemplateEntity  templateEntity) {
		
		return Template.builder()
				.name(templateEntity.getName())
				.subject(templateEntity.getSubject())
				.status(String.valueOf(templateEntity.getStatus()))
				.content(templateEntity.getContent())
				.id(templateEntity.getId())
				.build();
	}
}
