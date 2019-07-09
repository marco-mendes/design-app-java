package laboratorio3.parte3.exemplos;

import java.util.function.Consumer;

public class Exemplo_1 {

    public static void main(String[] args) {
        Consumer<Integer> display = n -> System.out.println(String.format("Imprimindo número: %s", n));
        display.accept(5);
    }
}