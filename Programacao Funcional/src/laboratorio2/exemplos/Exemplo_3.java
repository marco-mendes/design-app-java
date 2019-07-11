package laboratorio2.exemplos;

import java.util.Optional;

public class Exemplo_3 {

    public static void main(String[] args) {

        Optional<String> optionalVazio = Optional.empty();
        Optional<String> optionalNaoNulo = Optional.of("Valor recebido não é nulo!");
        Optional<String> optionalPodeOuNaoSerNulo = Optional.ofNullable(null);
        Optional<String> optionalPodeOuNaoSerNulo1 = Optional.ofNullable("Optional não nulo");

    }

}
