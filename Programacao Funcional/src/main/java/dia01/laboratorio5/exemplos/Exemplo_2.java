package dia01.laboratorio5.exemplos;

import java.util.function.Function;

public class Exemplo_2 {

    public static void main(String[] args) {

        Function<Integer,
                Function<Integer, Integer>> curryingSomaDoisValores = u -> v -> u + v;
        System.out.println(
                curryingSomaDoisValores
                        .apply(5)
                        .apply(10)
        );

    }

}
