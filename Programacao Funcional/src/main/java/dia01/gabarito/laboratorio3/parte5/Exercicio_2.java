package dia01.gabarito.laboratorio3.parte5;

import java.util.function.BinaryOperator;

public class Exercicio_2 {

    public static void main(String[] args) {

        BinaryOperator<Double> obtemRaizQuadradaDaSubtracao = (value1, value2) -> Math.sqrt(value1 - value2);
        System.out.println(obtemRaizQuadradaDaSubtracao.apply(70.0, 6.0));

    }

}