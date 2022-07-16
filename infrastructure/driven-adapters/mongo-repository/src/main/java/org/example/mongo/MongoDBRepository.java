package org.example.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepository extends ReactiveMongoRepository<PetDocument, String>, ReactiveQueryByExampleExecutor<PetDocument> {
}
