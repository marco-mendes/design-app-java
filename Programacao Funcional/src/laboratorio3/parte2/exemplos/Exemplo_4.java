package laboratorio3.parte2.exemplos;

import java.util.function.Predicate;

public class Exemplo_4 {

    public static void main(String[] args) {
        Predicate<Integer> maiorQueDez = (i) -> i > 10;
        Predicate<Integer> maiorQueDezNegado = maiorQueDez.negate();
        System.out.println(maiorQueDezNegado.test(15));
    }

}
