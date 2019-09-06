package gabarito.laboratorio1.parte3.exercicios;

/*
Crie 3 coleções imutáveis utilizando o método of das interfaces List, Set e Map para uma coleção de 5 números inteiros.
* */

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exercicio_2 {

    public static void main(String[] args) {
        List<Integer> listaImutavel = List.of(1,2,3,4,5);
        Set<Integer> setImutavel = Set.of(1,2,3,4,5);
        Map<String, Integer> mapImutavel = Map.of("Chave 1", 1, "Chave 2", 2, "Chave 3", 3, "Chave 4", 4, "Chave 5", 5);
    }

}
