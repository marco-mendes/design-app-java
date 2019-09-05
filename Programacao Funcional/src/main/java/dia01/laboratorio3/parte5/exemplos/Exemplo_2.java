package dia01.laboratorio3.parte5.exemplos;

import java.util.function.BinaryOperator;

public class Exemplo_2 {

    public static void main(String[] args) {
        BinaryOperator<Integer> somaNumeros = (a, b) -> a + b;
        System.out.println(somaNumeros.apply(5,5));
    }

}