package com.exemplos;

import java.util.Arrays;
import java.util.List;

public class Exemplo_1 {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int media = calculadora.calculaMedia(Arrays.asList(1,2,3,4,5));
    }

}

class Calculadora implements Calculator {

    @Override
    public int calculoSimples(int a, int b) {
        return a + b;
    }

}

interface Calculator {

    int calculoSimples(int a, int b);

    default int calculaMedia(List<Integer> valores){
        int totalElementos = valores.size();
        int media = somaValores(valores) / totalElementos;
        return media;
    }

    private int somaValores(List<Integer> valores) {
        int soma = valores.stream()
                .reduce(0, (a, b) -> a + b);
        return soma;
    }

}
