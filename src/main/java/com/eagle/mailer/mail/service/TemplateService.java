package com.eagle.mailer.mail.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eagle.mailer.context.MailerContext;
import com.eagle.mailer.entity.TemplateEntity;
import com.eagle.mailer.enums.StatusEnum;
import com.eagle.mailer.execption.DataBaseException;
import com.eagle.mailer.modal.Template;
import com.eagle.mailer.repository.TemplateRepository;
import com.eagle.mailer.transformer.TemplateEntityToModel;
import com.eagle.mailer.transformer.TemplateModelToEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TemplateService {

	private static final String EXP_MSG = "Execption occured while performing the operation for Tempate name/Id %s for client %s";

	private final TemplateEntityToModel templateEntityToModel;
	private final TemplateModelToEntity templateModelToEntity;
	private final TemplateRepository templateRepository;

	public void delete(Long id) {
		TemplateEntity templateEntity = fetchById(id);
		
		if (Objects.nonNull(templateEntity)) {
			templateEntity.setStatus(StatusEnum.DELETED.code());
			process(templateEntity);
		}
	}

	public List<Template> findAll() {
		List<TemplateEntity> templateEntities = templateRepository
				.findByClientIdAndStatusNotIn(MailerContext.getClientId(),Arrays.asList(StatusEnum.INACTIVE.code(), StatusEnum.DELETED.code()));
		return templateEntities.stream().map(templateEntity -> templateEntityToModel.apply(templateEntity))
				.collect(Collectors.toList());
	}

	public Template findById(Long id) {
		TemplateEntity templateEntity = fetchById(id);
		return Objects.nonNull(templateEntity) ? templateEntityToModel.apply(templateEntity) : null;

	}

	public Template save(Template template) {
		template.setId(0);
		template.setStatus(StatusEnum.ACTIVE.name());
		return process(template);
	}

	public Template update(Template template) {
		if (Objects.nonNull(template.getId()) && Objects.nonNull(fetchById(template.getId()))) {
			process(template);
		}
		return template;
	}

	private TemplateEntity fetchById(Long id) {
		TemplateEntity template = null;

		try {
			template = templateRepository.findByIdAndClientIdAndStatusNotIn(id, MailerContext.getClientId(),
					Arrays.asList(StatusEnum.INACTIVE.code(), StatusEnum.DELETED.code()));
		} catch (Exception exp) {
			throwException(String.valueOf(id), exp);
		}
		return Objects.nonNull(template) ? template : null;
	}

	private Template process(Template template) {
		TemplateEntity templateEntity = process(templateModelToEntity.apply(template));
		template.setId(templateEntity.getId());
		return template;
	}

	private TemplateEntity process(TemplateEntity templateEntity) {
		try {
			templateEntity = templateRepository.save(templateEntity);
		} catch (Exception exp) {
			throwException(String.valueOf(templateEntity.getName()), exp);
		}
		return templateEntity;
	}

	private void throwException(String templateId, Exception exp) {
		throw new DataBaseException(String.format(EXP_MSG, templateId, MailerContext.getClientId()), exp);
	}

}
