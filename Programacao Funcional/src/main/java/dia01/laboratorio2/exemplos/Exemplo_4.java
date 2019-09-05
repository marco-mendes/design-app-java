package dia01.laboratorio2.exemplos;

import java.util.Optional;

public class Exemplo_4 {

    public static void main(String[] args) {

        Optional<String> optionalNulo = Optional.ofNullable(null);
        Optional<String> optionalNaoNulo = Optional.ofNullable("Optional não nulo");

        System.out.println(
                String.format("O Optional contém algum valor? %b", optionalNulo.isPresent())
        );
        System.out.println(
                String.format("O Optional contém algum valor? %b", optionalNaoNulo.isPresent())
        );

    }

}
