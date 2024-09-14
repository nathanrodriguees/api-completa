package com.api.APIUsuarioComunidade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.APIUsuarioComunidade.model.UsuarioComunidade;

@Repository
public interface UsuarioComunidadeRepository extends MongoRepository<UsuarioComunidade, String>	{

}
