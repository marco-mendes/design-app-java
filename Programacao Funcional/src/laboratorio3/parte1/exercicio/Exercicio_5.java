package laboratorio3.parte1.exercicio;

import java.util.function.Function;

/*

Com base no código abaixo invoque o método calcular passando como parâmetro para ele uma função que calcule a raiz quadrada do número informado como parâmetro.
Após a invocação do método imprima o valor retornado no console.

* */

public class Exercicio_5 {

    public static Double calcular (Double valor, Function<Double, Double> operation){
        return operation.apply(valor);
    }

    public static void main(String[] args) {

    }

}