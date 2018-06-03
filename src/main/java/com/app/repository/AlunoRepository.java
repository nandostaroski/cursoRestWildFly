package com.app.repository;

import com.app.entity.Aluno;
import com.app.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Fernando on 03/06/2018.
 */
public interface AlunoRepository extends MongoRepository<Aluno,String> {
}
