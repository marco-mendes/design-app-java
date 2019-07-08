package laboratorio3.parte1.exemplos;

import java.util.function.Function;

public class Exemplo_3 {

    public static void main(String[] args) {

        Function<Integer, Integer> funcaoDobro = n -> n * 2;
        Function<Integer, Integer> funcaoNumeroMaisCincoVezesDois = funcaoDobro.compose(n -> n + 5);
        // Imprime no console o valor 30
        System.out.println(funcaoNumeroMaisCincoVezesDois.apply(10));

    }

}
