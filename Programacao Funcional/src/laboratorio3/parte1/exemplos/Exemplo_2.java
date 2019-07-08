package laboratorio3.parte1.exemplos;

import java.util.function.Function;

public class Exemplo_2 {

    public static void main(String[] args) {
        Function<Integer, Integer> funcaoDobro = n -> n * 2;
        Function<Integer, Integer> funcaoDobroMaisCinco = funcaoDobro.andThen(n -> n + 5);
        // Imprime no console o valor 25
        System.out.println(funcaoDobroMaisCinco.apply(10));
    }

}
