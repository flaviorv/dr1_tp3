package com.dr1.tp3.model.repository;

import com.dr1.tp3.model.domain.MaterialDidatico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, String> {
}
