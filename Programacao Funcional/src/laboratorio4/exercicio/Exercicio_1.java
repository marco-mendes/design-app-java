package laboratorio4.exercicio;

import java.util.function.Function;

/*

Com base no código abaixo faça com que a função multiplicaNumeroPor2 se torne uma função pura novamente

* */

public class Exercicio_1 {

    public static void main(String[] args) {

        Integer multiplicador = 2;
        Function<Integer, Integer> multiplicaNumeroPor2 = (numero) -> numero * multiplicador;
        System.out.println(multiplicaNumeroPor2.apply(5));

    }

}