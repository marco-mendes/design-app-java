package com.exemplos;

import java.util.Optional;

public class Exemplo_2 {

    public static void main(String[] args) {
        Optional<Pessoa> optionalComValor = Optional.ofNullable(new Pessoa("João", 30));
        Optional<Pessoa> optionalSemValor = Optional.ofNullable(null);

        optionalComValor.ifPresentOrElse(p -> p.imprimePessoa(), () -> System.out.println("Este Optional de Pessoa está vazio"));
        optionalSemValor.ifPresentOrElse(p -> p.imprimePessoa(), () -> System.out.println("Este Optional de Pessoa está vazio"));

    }

}

class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void imprimePessoa() {
        System.out.println(String.format("Nome: %s, Idade: %s", this.nome, this.idade));
    }

}