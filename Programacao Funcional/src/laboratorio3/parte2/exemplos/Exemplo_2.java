package laboratorio3.parte2.exemplos;

import java.util.function.Predicate;

public class Exemplo_2 {

    public static void imprimeResultado(String message, Boolean resultado){
        System.out.println(String.format(message, resultado));
    }

    public static void main(String[] args) {

        Predicate<Integer> testeMaioridade = n -> (n > 18) ? true : false;
        Predicate<Integer> testeMaioridadeENaoIdoso = testeMaioridade.and(n -> (n < 60) ? true : false);
        imprimeResultado("É maior de idade e não é idoso? %b", testeMaioridadeENaoIdoso.test(65));
        imprimeResultado("É maior de idade e não é idoso? %b", testeMaioridadeENaoIdoso.test(42));

    }

}
