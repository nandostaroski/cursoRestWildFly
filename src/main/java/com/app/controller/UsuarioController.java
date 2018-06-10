package com.app.controller;

import com.app.entity.Usuario;
import com.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

/**
 * Created by Fernando on 03/06/2018.
 */
@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> listUsuario() {
        return repository.findAll() ;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario save(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public Usuario edit(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

    @RequestMapping(value = "/usuario/{nome}/like",method = RequestMethod.GET)
    public List<Usuario> listLike(@PathVariable String nome){
        return repository.findByNomeLikeIgnoreCase(nome);
    }

    @RequestMapping(value = "usuario/{nome}/full-text-search",method = RequestMethod.GET)
    public List<Usuario> listFullText(@PathVariable String nome) {
        Pageable pages = new PageRequest(0,10,new Sort(new Sort.Order(ASC,"score")));

        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(nome);

        return repository.findAllBy(criteria,pages);
    }

}
