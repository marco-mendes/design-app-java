package dia01.gabarito.laboratorio3.parte1;

import java.util.function.Function;

public class Exercicio_1 {

    public static void main(String[] args) {

        Function<String, String> helloPeople = (nome) -> "Hello " + nome;
        System.out.println(helloPeople.apply("Jhon"));

    }

}
