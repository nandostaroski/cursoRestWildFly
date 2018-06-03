package com.app.entity;

import java.util.Date;

/**
 * Created by Fernando on 03/06/2018.
 */
public class Aluno extends EntidadeGenerica {
    private String nome;
    private Date dtNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
