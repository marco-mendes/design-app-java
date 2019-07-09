package laboratorio3.parte5.exemplos;

import java.util.function.UnaryOperator;

public class Exemplo_1 {

    public static void main(String[] args) {

        UnaryOperator<Double> obtemRaizQuadrada = (valor) -> Math.sqrt(valor);
        System.out.println(String.format("Raiz Quadrada: %s", obtemRaizQuadrada.apply(25.0)));

    }

}