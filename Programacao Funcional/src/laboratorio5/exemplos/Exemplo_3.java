package laboratorio5.exemplos;

import java.util.function.Function;

public class Exemplo_3 {

    public static void main(String[] args) {

        Function<Integer,
                Function<Integer,
                        Function<Integer, Integer>>> curryingSomaTresValores = u -> v -> w -> u + v + w;
        System.out.println(
                curryingSomaTresValores
                        .apply(5)
                        .apply(10)
                        .apply(15)
        );

    }

}
