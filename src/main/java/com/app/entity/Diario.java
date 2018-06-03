package com.app.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by Fernando on 03/06/2018.
 */
public class Diario extends EntidadeGenerica {
    private Date data;
    private boolean presenca;

    @DBRef
    private Aluno aluno;

    @DBRef
    private Modulo modulo;


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }
}
