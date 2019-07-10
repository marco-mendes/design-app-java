package laboratorio5.exercicio;

import java.util.function.Function;

public class Exercicio_2 {

    public static void main(String[] args) {

        Function<Integer,
                Function<Integer, Integer>> curryingMultiplicaValores = v1 -> v2 -> v1 * v2;
        System.out.println(
                curryingMultiplicaValores
                        .apply(5)
                        .apply(6)
        );

    }

}
