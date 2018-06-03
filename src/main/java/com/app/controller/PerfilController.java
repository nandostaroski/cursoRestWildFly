package com.app.controller;

import com.app.entity.Perfil;
import com.app.repository2.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Fernando on 03/06/2018.
 */
@RestController
public class PerfilController {

    @Autowired
    PerfilRepository repository;

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public List<Perfil> listPerfil() {
        return repository.findAll() ;
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.POST)
    public Perfil save(@RequestBody Perfil perfil) {
        return repository.save(perfil);
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.PUT)
    public Perfil edit(@RequestBody Perfil perfil) {
        return repository.save(perfil);
    }

    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

}
