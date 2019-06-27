package prototipodescartado.laboratorio3.exemplos;

import java.util.function.BiFunction;

public class ExemploIFBiFunction {

    public static void main(String[] args) {

        usoBasicoBiFunction();
        usoMetodoAndThen();

    }

    public static void usoBasicoBiFunction(){

        BiFunction<Integer, Integer, Integer> calculaSoma = (valor1, valor2) -> valor1 + valor2;

        System.out.println(calculaSoma.apply(20, 30));

    }

    public static void usoMetodoAndThen(){

        BiFunction<Integer, Integer, Integer> calculaSoma = (valor1, valor2) -> valor1 + valor2;
        BiFunction<Integer, Integer, Double> calculaRaizQuadradaDaSoma = calculaSoma.andThen(v -> Math.sqrt(v));

        System.out.println(calculaRaizQuadradaDaSoma.apply(40, 24));

    }

}
