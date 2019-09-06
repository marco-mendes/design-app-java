package laboratorio2.exemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo_3 {

    public static void main(String[] args) {
        Stream<String> valores = Stream.of("Valor 1", "Valor 2", "Valor 3");

        List<String> listaImutavel = valores.collect(Collectors.toUnmodifiableList());
        System.out.println(listaImutavel);
    }

}
