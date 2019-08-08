package com.exemplo;

import java.util.Optional;

public class Exemplo_2 {

    public static void main(String[] args) {
        Optional<String> optionalNulo = Optional.ofNullable(null);
        Optional<String> optionalPreenchido = Optional.ofNullable("Algum valor");

        System.out.println(String.format("Optional está vazio? %s", optionalNulo.isEmpty()));
        System.out.println(String.format("Optional está vazio? %s", optionalPreenchido.isEmpty()));
    }

}
