package com.eagle.mailer.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eagle.mailer.entity.TemplateEntity;

public interface TemplateRepository extends MongoRepository<TemplateEntity, Long>{

	TemplateEntity findByIdAndClientIdAndStatusNotIn(Long id ,String clientId, List<Integer> status) ;
	
	List<TemplateEntity> findByClientId();
	
	List<TemplateEntity> findByClientIdAndStatusNotIn(String clientId,List<Integer> status);

}
