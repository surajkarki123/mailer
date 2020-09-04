package com.eagle.mailer.repository;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.eagle.mailer.entity.SenderEntity;

public interface SenderRepository extends MongoRepository<SenderEntity, BigInteger> {
	
	SenderEntity findByIdAndClientIdAndStatusNotIn(BigInteger id ,String clientId, List<Integer> status) ;

}
