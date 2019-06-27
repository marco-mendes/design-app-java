package prototipodescartado.laboratorio7.exemplos;

import java.util.function.UnaryOperator;

public class ExemploIFUnaryOperator {

    public static void main(String[] args) {

        UnaryOperator<Double> obtemRaizQuadrada = (valor) -> Math.sqrt(valor);
        System.out.println("Raiz Quadrada: " + obtemRaizQuadrada.apply(25.0));

    }

}
