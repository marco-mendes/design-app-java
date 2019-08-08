package com.exemplo;

import java.util.Arrays;
import java.util.List;

public class Exemplo_3 {

    public static void main(String[] args) {
        List<String> listaNomes = List.of("Silvana", "Helena", "Mike", "John");
        String[] arrayNomes = listaNomes.toArray(String[]::new);
        System.out.println(Arrays.toString(arrayNomes));

        List<Integer> listaInteiros = List.of(1,2,3,4,5);
        Integer[] arrayInteiros = listaInteiros.toArray(Integer[]::new);
        System.out.println(Arrays.toString(arrayInteiros));
    }

}
