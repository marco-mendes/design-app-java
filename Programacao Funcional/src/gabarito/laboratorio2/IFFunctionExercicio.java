package gabarito.laboratorio2;

import java.util.function.Function;

// Exercício relacionado a Interface Funcional Function
public class IFFunctionExercicio {

    public static void main(String[] args) {

        //Resolvido
        Function<Double, Double> funcaoRaizQuadrada = (value) -> Math.sqrt(value);
        double valor = 25;
        calcula(valor, funcaoRaizQuadrada);

    }

    public static double calcula(double value, Function<Double, Double> operation){
        // Resolvido
        double resultado = operation.apply(value);
        System.out.println("Resultado da operação: " + resultado);
        return resultado;
    }

}