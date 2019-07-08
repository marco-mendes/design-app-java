package laboratorio3.parte2.exemplos;

import java.util.function.Predicate;

public class Exemplo_5 {

    public static void main(String[] args) {
        Predicate<String> isBrasileiro = Predicate.isEqual("Brasileiro");
        System.out.println(String.format("É Brasileiro? %b", isBrasileiro.test("Brasileiro")));
        System.out.println(String.format("É Brasileiro? %b", isBrasileiro.test("Argentino")));
    }

}
