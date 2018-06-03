package com.app.controller;

import com.app.entity.Modulo;
import com.app.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Fernando on 03/06/2018.
 */
@RestController
public class ModuloController {
    @Autowired
    ModuloRepository repository;

    @RequestMapping(value = "/modulo", method = RequestMethod.GET)
    public List<Modulo> listModulo() {
        return repository.findAll() ;
    }

    @RequestMapping(value = "/modulo", method = RequestMethod.POST)
    public Modulo save(@RequestBody Modulo modulo) {
        return repository.save(modulo);
    }

    @RequestMapping(value = "/modulo", method = RequestMethod.PUT)
    public Modulo edit(@RequestBody Modulo modulo) {
        return repository.save(modulo);
    }

    @RequestMapping(value = "/modulo/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

}
