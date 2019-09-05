package dia01.laboratorio3.parte1.exemplos;

import java.util.function.BiFunction;

public class Exemplo_5 {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> calculaSoma = (valor1, valor2) -> valor1 + valor2;
        BiFunction<Integer, Integer, Double> calculaRaizQuadradaDaSoma = calculaSoma.andThen(v -> Math.sqrt(v));

        System.out.println(calculaRaizQuadradaDaSoma.apply(40, 24));

    }

}