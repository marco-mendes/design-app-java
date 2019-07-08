package laboratorio3.parte1.exercicio;

import java.util.function.Function;

public class Exercicio_5 {

    public static double calcular(double value, Function<Double, Double> operation){

        double resultado = operation.apply(value);

        System.out.println("Resultado da operação: " + resultado);
        return resultado;

    }

    public static void main(String[] args) {

        Function<Double, Double> funcaoRaizQuadrada = (parametro) -> Math.sqrt(parametro);
        double valor = 25;
        calcular(valor, funcaoRaizQuadrada);

    }

}