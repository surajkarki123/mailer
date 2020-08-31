package com.eagle.mailer.sequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.math.BigInteger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import com.eagle.mailer.entity.sequence.RecipientSequenceEntity;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RecipientSequenceRepository {

	 private static final String SEQUENCE_NAME = "senderSequence";
	 private final MongoOperations mongo;

	    public BigInteger getNextSequence() {
	        return mongo.findAndModify(query(where("_id").is(SEQUENCE_NAME)), new Update().inc("seq", 1),
	                options().returnNew(true).upsert(true), RecipientSequenceEntity.class).getSeq();
	    }
}
