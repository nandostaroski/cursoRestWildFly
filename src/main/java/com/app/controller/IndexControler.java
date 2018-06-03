package com.app.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Fernando on 31/05/2018.
 */
@RestController
public class IndexControler {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Teste";
    }

    /*
    @RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
    public String index(@PathVariable String nome) {
        return "Teste: " + nome;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario index(@RequestBody Usuario usuario) {
        return usuario;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public Usuario indexPut(@RequestBody Usuario usuario) {
        return usuario;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.DELETE)
    public Usuario indexDelete(@RequestBody Usuario usuario) {
        return usuario;
    }
    */
}
