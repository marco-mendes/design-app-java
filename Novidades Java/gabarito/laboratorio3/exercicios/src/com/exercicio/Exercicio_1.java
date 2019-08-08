package com.exercicio;

/*
 * Remova os espaços em branco à esquerda da variável **valor** e imprima o resultado no console.
 * Remova os espaços em branco à direita da variável **valor** e imprima o resultado no console.
 * Remova os espaços em branco à esquerda e a direita da variável **valor** e imprima o resultado no console.
 * Transforme a variável **produtos** em uma Stream com as linhas extraídas da variável e em seguida imprima os valores da mesma no console.
 * Utilizando a variável **helloJava**, repita o valor da mesma 5 vezes utilizando o método mais adequado a isso, em seguida imprima o resultado no console.
* */


import java.util.stream.Stream;

public class Exercicio_1 {

    public static void main(String[] args) {
        String valor = "      VALOR PARA TESTES      ";
        String produtos = "Celular \nNotebook \nTelevisão \nPlay Station 4 \nXbox One \nMicroondas";
        String helloJava = "Hello Java 11\n";


        System.out.println(valor.stripLeading());
        System.out.println(valor.stripTrailing());
        System.out.println(valor.strip());

        Stream<String> streamProdutos = produtos.lines();
        streamProdutos.forEach(p -> System.out.println(p));

        System.out.println(helloJava.repeat(5));

    }

}
