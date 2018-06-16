package com.app.entity;

/**
 * Created by Fernando on 09/06/2018.
 */
public class Arquivo extends EntidadeGenerica {

    private String descricao;

    private Long tamanho;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getTamanho() {
        return tamanho;
    }

    public void setTamanho(Long tamanho) {
        this.tamanho = tamanho;
    }
}
