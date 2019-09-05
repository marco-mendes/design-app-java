package dia01.laboratorio3.parte3.exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Exemplo_2 {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        Consumer<Integer> display = n -> System.out.println(String.format("Imprimindo número: %s", n));
        integerList.forEach(display);
    }
}