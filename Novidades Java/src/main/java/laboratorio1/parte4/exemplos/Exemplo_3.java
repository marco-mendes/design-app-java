package laboratorio1.parte4.exemplos;

import java.util.Optional;
import java.util.stream.Stream;

public class Exemplo_3 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Algum valor");
        Stream<String> optionalConvertidoEmStream = optional.stream();
        optionalConvertidoEmStream.forEach(v -> System.out.println(v));
    }

}
