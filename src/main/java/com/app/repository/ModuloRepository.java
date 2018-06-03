package com.app.repository;

import com.app.entity.Modulo;
import com.app.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Fernando on 03/06/2018.
 */
public interface ModuloRepository extends MongoRepository<Modulo,String> {
}
