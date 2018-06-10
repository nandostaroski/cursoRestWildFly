package com.app.repository;

import com.app.entity.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Fernando on 03/06/2018.
 */
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    List<Usuario> findByNomeLikeIgnoreCase(String nome);

    List<Usuario> findAllBy(TextCriteria criteria, Pageable pages);
}
