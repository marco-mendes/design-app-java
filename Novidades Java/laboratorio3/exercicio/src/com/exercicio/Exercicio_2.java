package com.exercicio;

import java.util.List;

public class Exercicio_2 {

    public static List<Produto> obtemListaProdutos() {
        return List.of(
                new Produto("Samsung Galaxy J5 Prime", 899.99),
                new Produto("IPhone X", 4999.99),
                new Produto("Geladeira", 1249.99),
                new Produto("Xiaomi Mi 9", 2499.99),
                new Produto("Microondas", 349.99)
        );
    }

    public static void main(String[] args) {
        List<Produto> listaProdutos = obtemListaProdutos();
    }

}

class Produto {

    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

}
