package dia01.laboratorio3.parte2.exemplos;

import java.util.function.Predicate;

public class Exemplo_1 {

    public static void main(String[] args) {

        Predicate<Integer> testeMaioridade = n -> (n > 18) ? true : false;
        int maiorDeIdade = 28;
        int menorDeIdade = 17;
        System.out.println("É maior de idade? " + testeMaioridade.test(maiorDeIdade));
        System.out.println("É maior de idade? " + testeMaioridade.test(menorDeIdade));

    }
}