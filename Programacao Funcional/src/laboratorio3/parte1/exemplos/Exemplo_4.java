package laboratorio3.parte1.exemplos;

import java.util.function.BiFunction;

public class Exemplo_4 {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> calculaSoma = (valor1, valor2) -> valor1 + valor2;

        System.out.println(calculaSoma.apply(20, 30));

    }

}