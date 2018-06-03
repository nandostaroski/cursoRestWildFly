package com.app.controller;

import com.app.entity.Usuario;
import com.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
