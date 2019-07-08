package laboratorio3.parte1.exercicio;

import java.util.function.BiFunction;

public class Exercicio_3 {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> multiplicar = (valor1, valor2) -> valor1 * valor2;

        System.out.println(multiplicar.apply(10, 5));

    }

}