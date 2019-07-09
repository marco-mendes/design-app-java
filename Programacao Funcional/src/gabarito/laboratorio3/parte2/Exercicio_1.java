package gabarito.laboratorio3.parte2;

import java.util.function.Predicate;

public class Exercicio_1 {

    public static void main(String[] args) {
        Predicate<Integer> verificaIdadeIdosa = (idade) -> (idade > 65) ? true : false;
        int idadeNaoIdosa = 32;
        int idadeIdosa = 67;
        System.out.println(verificaIdadeIdosa.test(idadeNaoIdosa));
        System.out.println(verificaIdadeIdosa.test(idadeIdosa));
    }

}
