package dia01.laboratorio3.parte5.exemplos;

import java.util.function.BinaryOperator;

public class Exemplo_4 {

    public static void main(String[] args) {

        BinaryOperator<Integer> menorNumero = BinaryOperator.minBy((a, b) -> a.compareTo(b));
        System.out.println(menorNumero.apply(18, 60));

    }

}