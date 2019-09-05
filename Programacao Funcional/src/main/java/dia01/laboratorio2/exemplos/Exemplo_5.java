package dia01.laboratorio2.exemplos;

import java.util.Optional;

public class Exemplo_5 {

    public static void main(String[] args) {
        Optional<String> optionalNaoNulo = Optional.of("Não nulo!");
        System.out.println(optionalNaoNulo.get());
    }

}
