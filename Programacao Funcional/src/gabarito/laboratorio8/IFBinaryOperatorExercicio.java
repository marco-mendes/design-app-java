package gabarito.laboratorio8;

import java.util.function.BinaryOperator;

public class IFBinaryOperatorExercicio {

    public static void main(String[] args) {

        BinaryOperator<Double> obtemRaizQuadradaDaSubtracao = (value1, value2) -> Math.sqrt(value1 - value2);
        System.out.println(obtemRaizQuadradaDaSubtracao.apply(70.0, 6.0));

    }

}