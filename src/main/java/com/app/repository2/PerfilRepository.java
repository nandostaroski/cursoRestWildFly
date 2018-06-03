package com.app.repository2;

import com.app.entity.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Fernando on 03/06/2018.
 */
public interface PerfilRepository extends MongoRepository<Perfil,String> {
}
