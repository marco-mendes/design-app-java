package laboratorio3.parte2.exemplos;

import java.util.function.Predicate;

public class Exemplo_2 {

    public static void main(String[] args) {

        Predicate<Integer> testeMaioridade = n -> (n > 18) ? true : false;
        Predicate<Integer> testeMaioridadeENaoIdoso = testeMaioridade.and(n -> (n < 60) ? true : false);
        System.out.println("É maior de idade e não é idoso? " + testeMaioridadeENaoIdoso.test(65));
        System.out.println("É maior de idade e não é idoso? " + testeMaioridadeENaoIdoso.test(42));

    }

}
