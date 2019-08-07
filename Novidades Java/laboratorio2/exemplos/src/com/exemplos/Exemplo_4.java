package com.exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exemplo_4 {

    public static void exemploValorPresente() {
        List<String> listaNomes = Arrays.asList("João", "Maria", "Carlos", "Elsa", "Roberto");

        Optional<String> resultadoOptional = listaNomes.stream().filter(n -> n.equals("Elsa")).findFirst();
        String resultado = resultadoOptional.orElseThrow();

        System.out.println(resultado);
    }

    public static void exemploValorNaoPresente() {
        List<String> listaNomes = Arrays.asList("João", "Maria", "Carlos", "Elsa", "Roberto");

        Optional<String> resultadoOptional = listaNomes.stream().filter(n -> n.equals("Jurema")).findFirst();
        String resultado = resultadoOptional.orElseThrow();

        System.out.println(resultado);
    }

    public static void main(String[] args) {
        exemploValorPresente();
        exemploValorNaoPresente();
    }

}