package com.api.APIUsuarioComunidade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.APIUsuarioComunidade.model.Comunidade;


@Repository
public interface ComunidadeRepository extends MongoRepository<Comunidade, String>{

	
	
}
