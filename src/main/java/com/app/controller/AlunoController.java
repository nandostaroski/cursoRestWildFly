package com.app.controller;

import com.app.entity.Aluno;
import com.app.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Fernando on 03/06/2018.
 */
@RestController
public class AlunoController {
    @Autowired
    AlunoRepository repository;

    @RequestMapping(value = "/aluno", method = RequestMethod.GET)
    public List<Aluno> listAluno() {
        return repository.findAll() ;
    }

    @RequestMapping(value = "/aluno", method = RequestMethod.POST)
    public Aluno save(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }

    @RequestMapping(value = "/aluno", method = RequestMethod.PUT)
    public Aluno edit(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }

    @RequestMapping(value = "/aluno/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

}
