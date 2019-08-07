package com.exemplos;

import java.util.Optional;

public class Exemplo_1 {

    public static void main(String[] args) {
        Optional<String> optionalVazio = Optional.empty();
        Optional<String> optionalDefault = Optional.of("Valor default");

        Optional<String> resultado = optionalVazio.or(() -> optionalDefault);
        System.out.println(resultado.get());
    }

}
