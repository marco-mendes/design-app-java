package gabarito.laboratorio5;

import java.util.function.Consumer;
import java.util.function.Function;

public class Exercicio_1 {

    public static void main(String[] args) {

        Function<Integer, Double> calculaRaizQuadrada = (valor) -> {

            Consumer<Double> imprimirRaizQuadrada = (raiz) -> System.out.println(
              String.format("O resultado da raiz quadrada do número %s é: %s", valor, raiz)
            );
            Double raizQuadrada = Math.sqrt(valor);
            imprimirRaizQuadrada.accept(raizQuadrada);
            return raizQuadrada;

        };

        calculaRaizQuadrada.apply(25);
        calculaRaizQuadrada.apply(64);

    }

}
