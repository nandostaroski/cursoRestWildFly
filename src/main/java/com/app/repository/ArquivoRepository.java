package com.app.repository;

import com.app.entity.Arquivo;
import com.app.entity.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Fernando on 03/06/2018.
 */
public interface ArquivoRepository extends MongoRepository<Arquivo,String> {

}
