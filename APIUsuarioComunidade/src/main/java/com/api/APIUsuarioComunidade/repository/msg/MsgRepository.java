package com.api.APIUsuarioComunidade.repository.msg;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.APIUsuarioComunidade.model.msg.Msg;

@Repository
public interface MsgRepository extends MongoRepository<Msg, String>{

}
