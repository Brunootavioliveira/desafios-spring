package br.com.brunootavio.desafios_spring.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Tarefa {
    @JsonAlias("descricao") private String descricao;
    @JsonAlias("concluido") private boolean concluido;
    @JsonAlias("pessoaResponsavel") private String pessoaResponsavel;

    public Tarefa() {
    }

    public Tarefa(String descricao, boolean concluido, String pessoaResponsavel) {
        this.descricao = descricao;
        this.concluido = concluido;
        this.pessoaResponsavel = pessoaResponsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public String getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    @Override
    public String toString() {
        return "Tarefa:\n" +
                "Descrição: " + descricao + "\n" +
                "Concluído: " + concluido + "\n" +
                "Pessoa responsável: " + pessoaResponsavel;
    }

}
