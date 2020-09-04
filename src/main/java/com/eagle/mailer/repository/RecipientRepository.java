package com.eagle.mailer.repository;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.eagle.mailer.entity.RecipientEntity;

public interface RecipientRepository extends MongoRepository<RecipientEntity, BigInteger>{
	
	RecipientEntity findByIdAndClientIdAndStatusNotIn(BigInteger id ,String clientId, List<Integer> status) ;

}
