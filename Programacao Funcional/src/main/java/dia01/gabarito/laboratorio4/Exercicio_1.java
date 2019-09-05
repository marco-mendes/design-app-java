package dia01.gabarito.laboratorio4;

import java.util.function.Function;

public class Exercicio_1 {

    public static void main(String[] args) {

        Function<Integer, Integer> multiplicaNumeroPor2 = (numero) -> numero * 2;
        System.out.println(multiplicaNumeroPor2.apply(5));

    }

}