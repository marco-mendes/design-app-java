package com.exercicio;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercicio_2 {

    public static void main(String[] args) {
        Stream<Integer> streamDeInteiros = Stream.of(1, 2, 3, 4, 5);
        Set<Integer> setDeInteiros = streamDeInteiros.collect(Collectors.toUnmodifiableSet());
        System.out.println(setDeInteiros);
    }

}
