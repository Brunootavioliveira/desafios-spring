package br.com.brunootavio.desafios_spring.service;

public class Pessoa {
    private String name;
    private Integer idade;

    public Pessoa(String name, Integer idade) {
        this.name = name;
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public Integer getIdade() {
        return idade;
    }
}
