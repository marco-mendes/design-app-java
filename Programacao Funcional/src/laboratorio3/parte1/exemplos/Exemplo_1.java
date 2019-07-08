package laboratorio3.parte1.exemplos;

import java.util.function.Function;

public class Exemplo_1 {

    public static void main(String[] args) {
        Function<Integer, Integer> funcaoDobro = n -> n * 2;
        // Imprime no console o valor 20
        System.out.println(funcaoDobro.apply(10));
    }

}
