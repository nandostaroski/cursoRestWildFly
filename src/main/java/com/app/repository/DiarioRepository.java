package com.app.repository;

import com.app.entity.Aluno;
import com.app.entity.Diario;
import com.app.entity.Modulo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Fernando on 03/06/2018.
 */
public interface DiarioRepository extends MongoRepository<Diario,String> {

    List<Diario> findByAluno(Aluno aluno);
    List<Diario> findByModulo(Modulo modulo);
    List<Diario> findByDataBetween(Date dataDe, Date dataAte);
}
