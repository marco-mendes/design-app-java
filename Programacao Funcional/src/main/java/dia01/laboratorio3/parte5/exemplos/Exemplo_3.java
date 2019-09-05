package dia01.laboratorio3.parte5.exemplos;

import java.util.function.BinaryOperator;

public class Exemplo_3 {

    public static void main(String[] args) {

        BinaryOperator<Integer> maiorNumero = BinaryOperator.maxBy((a, b) -> a.compareTo(b));
        System.out.println(maiorNumero.apply(48, 6));

    }

}