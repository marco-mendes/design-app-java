package com.exemplos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Exemplo_2 {

    public static void main(String[] args) {
        List<String> listaImutavel = List.of("Valor 1", "Valor 2");
        List<String> copiaListaImutavel = List.copyOf(listaImutavel);
        System.out.println(copiaListaImutavel);

        Set<String> setImutavel = Set.of("Valor 1", "Valor 2");
        Set<String> copiaSetImutavel = Set.copyOf(setImutavel);
        System.out.println(copiaSetImutavel);

        Map<String, String> mapImutavel = Map.of("Chave 1", "Valor 1", "Chave 2", "Valor 2");
        Map<String, String> copiaMapImutavel = Map.copyOf(mapImutavel);
        System.out.println(copiaMapImutavel);
    }

}
