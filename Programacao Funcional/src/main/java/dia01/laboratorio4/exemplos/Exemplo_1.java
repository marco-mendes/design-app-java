package dia01.laboratorio4.exemplos;

import java.util.function.Function;

public class Exemplo_1 {

    public static void main(String[] args) {
        Function<Double, Double> calculaAreaCirculo = (raio) -> Math.PI * (Math.pow(raio, 2));
        System.out.println(calculaAreaCirculo.apply(5.0));
    }

}
