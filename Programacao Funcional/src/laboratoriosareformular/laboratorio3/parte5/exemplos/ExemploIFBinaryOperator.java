package laboratoriosareformular.laboratorio3.parte5.exemplos;

import java.util.function.BinaryOperator;

public class ExemploIFBinaryOperator {

    public static void main(String[] args) {

        usoBasicoBinaryOperator();
        usoMaxBy();
        usoMinBy();

    }

    public static void usoBasicoBinaryOperator(){

        BinaryOperator<Integer> somaNumeros = (a, b) -> a + b;
        System.out.println(somaNumeros.apply(5,5));

    }

    public static void usoMaxBy(){

        BinaryOperator<Integer> maiorNumero = BinaryOperator.maxBy((a, b) -> a.compareTo(b));
        System.out.println(maiorNumero.apply(48, 6));

    }

    public static void usoMinBy(){

        BinaryOperator<Integer> menorNumero = BinaryOperator.minBy((a, b) -> a.compareTo(b));
        System.out.println(menorNumero.apply(18, 60));

    }

}
